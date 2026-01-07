import sys

input = sys.stdin.readline

# I Speak TXTMSG (6841번)
_dict = {
    "CU": "see you",
    ":-)": "I’m happy",
    ":-(": "I’m unhappy",
    ";-)": "wink",
    ":-P": "stick out my tongue",
    "(~.~)": "sleepy",
    "TA": "totally awesome",
    "CCC": "Canadian Computing Competition",
    "CUZ": "because",
    "TY": "	thank-you",
    "YW": "you’re welcome",
    "TTYL": "talk to you later",
}

while True:
    txt = input().rstrip()
    print(_dict.get(txt, txt))
    if txt == "TTYL":
        break

