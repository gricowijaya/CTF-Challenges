#!/usr/bin/python3.10

print("PyFostJail v1.0")

bl = [' ','"',"'"]
code = input(">>> ").lower()
while not code.startswith('exit'):
	skip = list(filter(lambda c: c in bl, code)) or "__init__" in code or "__globals__" in code or "system" in code

	if skip:
		print("Malicious Code Detected!!!")
		code = input(">>> ").lower()
		continue

	try:
		exec(code, {'print': print, '__builtins__': {}})
	except Exception as e:
		print("Your code is broken!!!")
		print(f"Error: {e}")

	code = input(">>> ").lower()

