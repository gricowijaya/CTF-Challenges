from secret import FLAG
from Crypto.Util.number import bytes_to_long as b2l, long_to_bytes as l2b
import random

def generate_key(key_rounds):
    random.seed(13337)
    key = []
    for i in range(key_rounds):
        key.append(random.randint(1337, 13333337))
    return key

def feistel_cipher(left, right):
    try:
        left = b2l(left.encode())
        right = b2l(right.encode())
    except:
        assert isinstance(left, bytes) and isinstance(right, bytes)
        left = b2l(left)
        right = b2l(right)

    key = generate_key(35)
    prev_left = left
    prev_right = right
    for i in range(len(key)):
        left = prev_right
        right = prev_left ^ (prev_right ^ key[i])
        prev_left = left
        prev_right = right
    return l2b(left), l2b(right)


half = len(FLAG) // 2
left, right = FLAG[:half], FLAG[half:]

enc_left, enc_right = feistel_cipher(left, right)

with open("flag.enc", "w") as f:
    f.write(f"enc_left = {enc_left}\nenc_right = {enc_right}")