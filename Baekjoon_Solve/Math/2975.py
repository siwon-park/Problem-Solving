# Transactions (2975번)
import sys
input = sys.stdin.readline

while True:
    s, wd, amt = input().rstrip().split()
    s = int(s)
    amt = int(amt)
    if s == 0 and wd == 'W' and amt == 0:
        break
    bal = 0
    if wd == 'W':  # 인출
        bal = s - amt
    elif wd == 'D':
        bal = s + amt
    if bal < -200:
        print("Not allowed")
    else:
        print(bal)

