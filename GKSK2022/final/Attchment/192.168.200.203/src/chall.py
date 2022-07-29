#!/usr/bin/env python3

from base64 import b64encode, b64decode
from Crypto.Cipher import AES
import os
import string
import pickle

FLAG = open("flag.txt").read()

class User:
    def __init__(self, user_list):
        self.user_list = user_list

    def login_with_creds(self, username, password):
        for user in self.user_list:
            if user["username"] == username and user["password"] == password:
                if user["is_admin"]:
                    print("Welcome Admin...")
                    print(f"FLAG: {FLAG}")
                else:
                    print(f"Welcome {username}")
                exit()
            else:
                print("Invalid username/password")
    
    def login_with_token(self, token):
        try:
            pd = b64decode(token.encode())
            user = pickle.loads(pd)
            if user["is_admin"]:
                print("Welcome Admin...")
                print(f"FLAG: {FLAG}")
            else:
                print(f"Welcome {user['username']}")
            exit()
        except Exception:
            print("Invalid token")

    def register(self, username, password):
        uname_list = [x["username"] for x in self.user_list]
        if username not in uname_list:
            user_dict = {
                "username": username,
                "password": password,
                "is_admin": False
            }
            self.user_list.append(user_dict)
            token = b64encode(pickle.dumps(user_dict)).decode()
            
            return token
        else:
            return False

    def reset_password(self, username):
        uname_list = [x["username"] for x in self.user_list]
        if username in uname_list:
            x = int.from_bytes(os.urandom(1), 'little') % len(uname_list)
            t = uname_list[x]
            if len(t) < 16:
                y = ""
                for i in range(16):
                    y += t[i % len(t)]
            else:
                y = t[:16]
            init = "".join([chr(string.printable[:-5].index(q)) for q in y]).encode("latin1")
            
            key = os.urandom(16)
            aes = AES.new(key, AES.MODE_ECB)
            p = b"\x00" * 16
            ct = b""
            for i in range(len(p)):
                b = aes.encrypt(init)[0]
                c = b ^ p[i]
                ct += bytes([c])
                init = init[1:] + bytes([c])
            
            new_password = gen_passwd(ct)
            idx = uname_list.index(username)
            self.user_list[idx]["password"] = new_password
            print(f"Your password has been changed.")
        else:
            print("Invalid Username")

def xor(a,b):
    if len(a) == 0 or len(b) == 0:
        return None
    elif len(a) >= len(b):
        return [a[i] ^ b[i%len(b)] for i in range(len(a))]
    elif len(b) >= len(a):
        return [b[i] ^ a[i%len(a)] for i in range(len(b))]

def gen_passwd(rand):
    charset = string.printable[:-5]
    result = ""
    for r in rand:
        result += charset[r%len(charset)]

    return result

if __name__ == "__main__":
    user = User([{
        "username": "admin",
        "password": gen_passwd(os.urandom(64)),
        "is_admin": True
    }])

    while True:
        print("Welcome!!!")
        print("[1] Login")
        print("[2] Register")
        print("[3] Reset password")
        print("[4] Exit")
        inp = input("Input: ")
        print()

        if inp == "1":
            print("Select your login method:")
            print("[1] Using username + password")
            print("[2] Using Token")
            login_method = input("Input: ")
            print()

            if login_method == "1":
                username = input("Username: ")
                password = input("Password: ")

                # perform basic authentication
                user.login_with_creds(username, password)

            elif login_method == "2":
                token = input("Token: ")

                # pickle load, malleable token
                user.login_with_token(token)

            else:
                print("Unknown input...")
                continue
        elif inp == "2":
            username = input("Username: ")
            password = input("Password: ")

            # pickle dump
            token = user.register(username, password)
            if token:
                print(f"Your login token is: {token}")
            else:
                print("Username already exist.")

        elif inp == "3":
            username = input("Username: ")

            # do basic search, then zerologon
            user.reset_password(username)
        
        elif inp == "4":
            print("Bye...")
            exit()

        else:
            print("Unknown input...")
