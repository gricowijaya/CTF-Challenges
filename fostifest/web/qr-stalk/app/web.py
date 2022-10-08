import hashlib
import os
import random

from flask import (
    Blueprint,
    Flask,
    current_app,
    flash,
    redirect,
    render_template,
    request,
    url_for,
)
from werkzeug.utils import secure_filename

from . import qr, util

web_bp = Blueprint("web", "web")


@web_bp.route("/decode", methods=["GET", "POST"])
def decode():
    if request.method == "POST":
        # check if the post request has the file part
        if "filename" not in request.files:
            flash("No file part", "error")
            return redirect(request.url)
        file = request.files["filename"]
        # if user does not select file, browser also
        # submit a empty part without filename
        if file.filename == "":
            flash("Empty Filename", "error")
            return redirect(request.url)
        if file and util.allowed_file(file.filename):

            filename = secure_filename(file.filename)
            filename, ext = filename.split(".")
            filename = "{}.{}".format(hashlib.md5(filename).hexdigest(), ext)

            qr_location = os.path.join(current_app.config["UPLOAD_FOLDER"], filename)
            file.save(qr_location)
            if qr.decoder(qr_location):
                # os.remove(qr_location)
                return redirect(url_for("web.result"))
            else:
                flash("Something Went Wrong!", "error")
                return redirect(request.url)

            # return redirect(url_for('uploaded_file', filename=filename))
    return render_template("upload.html")


@web_bp.route("/encode", methods=["POST"])
def encode():
    if request.method == "POST":
        text = request.form["text"]
        filename = qr.encoder(text=text)
        # filename = os.path.join("/static/qr_files/",filename)
        return "<img src='{}' />".format(filename)


# @web_bp.route("/decode",methods=["POST"])
# def decode():
#     pass


@web_bp.route("/result")
def result():
    text = qr.qr_code_string
    return render_template("result.html", qr=qr, util=util)
