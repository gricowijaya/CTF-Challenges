from flask import Flask, render_template
from config import app_config
from lib import QRCODE, Utils


def create_app(config_name="development"):
    app = Flask(__name__)
    app.config.from_object(app_config[config_name])

    @app.route("/")
    def index():
        return render_template("upload.html", title="Home Page")
    load_bp(app)
    return app

def load_bp(app):
    from web import web_bp

    app.register_blueprint(web_bp)

qr = QRCODE()
util = Utils()
