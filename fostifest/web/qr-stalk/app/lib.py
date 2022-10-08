from qrtools import QR
from urlparse import urlparse

import hashlib
import random
import urllib
import unicodedata
import os
import shutil
from config import Base

ALLOWED_EXTENSIONS = set(['png', 'jpg', 'jpeg'])

class QRCODE:
    def __init__(self, filename=None):
        self.qr_code_string = None
        self.qr_code_type = None
        # self.
    def decoder(self,filename=None):
        q = QR(filename=filename)
        if q.decode():
            self.qr_code_string = unicodedata.normalize('NFKD', q.data_to_string().decode('utf-8')).encode('ascii','ignore')
            self.qr_code_type = str(q.data_type)
            os.remove(filename)
            print "Type : " + self.qr_code_type
            return True
        else:
            return False

    def encoder(self,text="Hello World",filename=None):
        q = QR(data=text)
        if q.encode() == 0:
            save_path = Base().UPLOAD_FOLDER
            shutil.move(q.filename,save_path)
            # return os.path.join(save_path,os.path.basename(q.filename))
            return os.path.basename(q.filename)
        else:
            return False
class Utils:
    def fetch_url(self, domain):
        if domain.startswith("file://") or domain.startswith("gopher://") or domain.startswith("ftp://"):
            return "{} is not allowed".format(domain)
        req = urllib.urlopen(domain)
        return req.read()

    def is_url(self,string):
        url_raw = urlparse(string)
        netloc = url_raw.netloc
        scheme = url_raw.scheme
        # print "Url raw : " + url_raw
        if scheme != "" and netloc != "" and not self.is_ip(netloc) and netloc != "0":
            return True
        else:
            return False

    def is_ip(self, domain):
        return domain.split('.')[-1].isdigit()

    def allowed_file(self,filename):
        return '.' in filename and \
            filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS
