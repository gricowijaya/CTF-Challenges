#!/usr/bin/env python3

from binascii import hexlify, unhexlify
from Crypto.Cipher import AES
import json
import random
import time
import os
import sys

class Unbuffered(object):
    def __init__(self,stream):
        self.stream = stream
    def write(self,data):
        self.stream.write(data)
        self.stream.flush()
    def writelines(self,data):
        self.stream.writelines(data)
        self.stream.flush()
    def __getattr__(self, attr):
        return getattr(self.stream,attr)

sys.stdout = Unbuffered(sys.stdout)

def pad(msg):
        msg = msg + b'1'

        for i in range(len(msg)):
            if len(msg) % 16 != 0:
                msg += b'0'

        return msg

key = b"abcdefghijklmnop"

class tokenFunc():
    def create(username,password):
        payload = {"Username":username + ";","IsAdmin":"000000000_False_;","is_the_Username_ssh_enabled":"yes;","Password":password + ";","cat_flag":"000000000_False_;"}
        session = json.dumps(payload).encode('latin1')
        cipher = AES.new(key, AES.MODE_ECB)
        msg = cipher.encrypt(pad(session))

        return hexlify(msg)

    def validate(token):

        decipher = AES.new(key, AES.MODE_ECB)
        msg_dec = decipher.decrypt(unhexlify(token))

        if b'"IsAdmin": "0000000_True_000;"' in msg_dec and b'"cat_flag": "0000000_True_000;"' in msg_dec:
            return open('../flag.txt','r').read()
        else:
            return "s.id/Flag"

def welcome():
    print("""
    WELCOME TO GKSK SECRECT FAULT
    =============================
    
    Whatcha gonna do?

    [1] Get flag
    [2] Play game
    """)

def main():
    welcome()
    select = input("your choise : ")
    if select == '1':
        os.system('clear')
        print("""
                    VERIFY
        ============================

        [1] login
        [2] register
        """)

        select = input('>>> ')

        if select == '1':
            tokn = input("\nGive me your token: ")
            res = tokenFunc.validate(tokn)
            os.system('clear')
            print(f"here is your flag : {res}")
        elif select == '2':
            print('\n')
            username = input('username: ')
            password = input('password: ')
            res = tokenFunc.create(username,password)
            leak = {"Username":username + ";","IsAdmin":"000000000_False_;","is_the_Username_ssh_enabled":"yes;","Password":password + ";","cat_flag":"000000000_False_;"}
            os.system('clear')
            print(f'here is your token : {res.decode()}\n')
            print(f'leaked : {json.dumps(leak)}')
        else:
            print('byebye')
            exit()


    elif select == '2':
        os.system('clear')
        random.seed(round(time.time() / 100, 5))
        print("""====================================

        [1] sample number
        [2] guess
        """)
        while True:
            select = input('your choise : ')
            if select == '1':
                print(f"\nour sample number is : {str(random.randint(1, 100000000))}\n")
            elif select == '2':
                if input(">>> ") == str(random.randint(1, 100000000)):
                    print('wow lucky you')
                    if input(">>> ") == str(random.randint(1, 100000000)):
                        print('good here is your reward')
                        print({
                            'username': 'beluga',
                            'ip_addr': '10.15.2.1',
                            'password': 's1mpl3_Rndm_101'
                            })
                    else:
                        print('try again!')
                else:
                    print('unlucky')
            else:
                print('byebye')
                exit()

    else:
        print("byebye")
        exit()

if __name__ == '__main__':
    while True:
        main()