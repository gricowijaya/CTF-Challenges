import os
from secret import FLAG
from base64 import b64encode

key = os.urandom(17)

ct = ""
for i, v in enumerate(FLAG):
    ct += chr(key[i%(len(key))] ^ ord(v))
ct = b64encode(ct.encode()).decode()
with open ("flag.enc", "w") as f: 
    f.write(ct)