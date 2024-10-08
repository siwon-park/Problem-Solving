# 문자열을 만들어요 (32297번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
S = input().rstrip()
flag = False
for i in range(N - 3):
    if S[i:i+4] == "gori":
        flag = True
        break

if flag:
    print("YES")
else:
    print("NO")

