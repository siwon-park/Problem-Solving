import sys

input = sys.stdin.readline

# Soft Passwords (18206번)
S = input().rstrip()
P = input().rstrip()

def validate(pwd1: str, pwd2: str) -> bool:
    if pwd1 == pwd2:
        return True
    if '0' <= pwd1[0] <= '9' and pwd1[1:] == pwd2:
        return True
    if '0' <= pwd1[-1] <= '9' and pwd1[:-1] == pwd2:
        return True
    rvrs_pwd1 = ""
    for ch in pwd1:
        if 'a' <= ch <= 'z':
            rvrs_pwd1 += ch.upper()
        elif 'A' <= ch <= 'Z':
            rvrs_pwd1 += ch.lower()
        else:
            rvrs_pwd1 += ch
    if rvrs_pwd1 == pwd2:
        return True
    return False

flag = validate(S, P)
if flag:
    print("Yes")
else:
    print("No")

