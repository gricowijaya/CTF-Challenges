#!/usr/bin/env python3
from Crypto.Cipher import AES
from Crypto.Util import Counter
import os
from secret import FLAG

key = os.urandom(16)

def encrypt(pt):
    cipher = AES.new(key, AES.MODE_CTR, counter=Counter.new(128))
    ciphertext = cipher.encrypt(pt)
    return ciphertext.hex()

test = "We never stop investigating. We are never satisfied that we know enough to get by. Every question we answer leads on to another question. This has become the greatest survival trick of our species.".encode()
test_enc = encrypt(test)
flag_enc = encrypt(FLAG.encode())

with open("flag.enc", "w") as f:
    f.write(f"test={test}\nflag_enc={flag_enc}\ntest_enc={test_enc}")