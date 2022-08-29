#!/usr/bin/python3.8

import sys
from os import urandom
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad


BIT = 16
FLAG = open("flag.txt", "r").read().strip()
SECRET = b"FLIP FLUP FLEP FLOP"
KEY = urandom(BIT)
IV = urandom(BIT)


def banner():
    print(
        """-================================-
███████╗██╗░░░░░██╗██████╗░
██╔════╝██║░░░░░██║██╔══██╗
█████╗░░██║░░░░░██║██████╔╝
██╔══╝░░██║░░░░░██║██╔═══╝░
██║░░░░░███████╗██║██║░░░░░
╚═╝░░░░░╚══════╝╚═╝╚═╝░░░░░
-================================-"""
    )


def encrypt(msg):
    msg = msg.encode()
    pt = pad(msg, BIT)
    aes = AES.new(KEY, AES.MODE_CBC, IV)
    ct = aes.encrypt(pt)
    enc = IV.hex() + ct.hex()
    return enc


def decrypt(ct):
    ct = bytes.fromhex(ct)
    iv = ct[:16]
    ct = ct[16:]
    aes = AES.new(KEY, AES.MODE_CBC, iv)
    pt = aes.decrypt(ct)
    pt = unpad(pt, BIT).decode()
    return pt


def main():
    print("Give me plaintext, then i will give you ciphertext.")
    pt = input("Plaintext: ")
    if pt.isprintable() and pt != SECRET.decode():
        ct = encrypt(pt)
    else:
        print("Forbidden.")
        return 0
    print(f"Ciphertext: {ct}")
    print("Now give me ciphertext in hex, then i will give you the flag if i can.")
    ct = input("Ciphertext (hex): ")
    pt = decrypt(ct)
    if pt == SECRET.decode():
        print(f"Congrats! Here is the flag : {FLAG}")
    else:
        print("Sorry, i can't.")
    return 0


if __name__ == "__main__":
    banner()
    main()
