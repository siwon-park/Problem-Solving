# 와글와글 숭고한 (17388번)
import sys
input = sys.stdin.readline

S, K, H = map(int, input().rstrip().split())
if S + K + H >= 100:
    print("OK")
else:
    ans = ""
    point = 101
    if S < point:
        ans = "Soongsil"
        point = S
    if K < point:
        ans = "Korea"
        point = K
    if H < point:
        ans = "Hanyang"
        point = H
    print(ans)
