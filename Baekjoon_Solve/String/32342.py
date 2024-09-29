# 와우와 쿼리 (32342번)
import sys
input = sys.stdin.readline

Q = int(input().rstrip())
for i in range(Q):
    S = input().rstrip()
    n = len(S)
    cnt = 0
    for j in range(n - 2):
        if S[j:j + 3] == "WOW":
            cnt += 1
    print(cnt)

