#!/usr/bin/env python3
from Crypto.Cipher import AES
import os

def encrypt(msg):
    IV = b'\x01'*16
    aes = AES.new(KEY,AES.MODE_CFB,IV)
    enc = aes.encrypt(msg)
    return enc

def input_check(inp,secret):
    if inp == secret:
        print("Wut ?")
        os.system("/bin/sh")
    else:
        print("WRONG!\n")

if __name__ == "__main__":
    print("WELCOME\n")
    print("can u break me?\n")
    while True:
        KEY = os.urandom(16)
        inp = input("Input: ").encode()

        if len(inp) < 8:
            print("8 Char required!\n")
            continue

        e = encrypt(inp)
        input_check(inp,e)
