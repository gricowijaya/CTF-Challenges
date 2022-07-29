#!/usr/bin/env python2 

from __future__ import print_function
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

print("""
Welcome, show me what you can do    
""")

banned = [
    "exec",
    "eval",
    "pickle",
    "subprocess",
    "sys",
    "dir",
    "import",
    "__builtins__"
]

targets = __builtins__.__dict__.keys()
targets.remove('raw_input')
targets.remove('print')
targets.remove('globals')
targets.remove('repr')
targets.remove('__import__')

for x in targets:
    del __builtins__.__dict__[x]

while 1:
    try:
        print("run code >>>", end=' ')
        data = raw_input()

        for no in banned:
            if no.lower() in data.lower():
                print("huh?")
                break
        else:
            exec data
    except:
        print("NotFound!")