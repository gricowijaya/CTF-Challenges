#!/usr/bin/env python3

import random
from secret import FLAG
from lorem import get_paragraph

lorem_ipsum = list(get_paragraph(count=6).lower())

last_pos = 0

for index in range(len(FLAG)):
    x = random.randrange(last_pos, last_pos + 30)
    lorem_ipsum[x] = FLAG[index]
    last_pos = x

lorem_ipsum = "".join(lorem_ipsum)

with open("flag.enc", "w") as f:
    f.write(lorem_ipsum)