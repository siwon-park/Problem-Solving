# 히든 넘버 (8595번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
line = input().rstrip()
ans = 0
hidden_num = 0
for i in range(N):
    if line[i].isalpha():
        ans += hidden_num
        hidden_num = 0
    else:
        hidden_num = hidden_num * 10 + int(line[i])

if hidden_num != 0:
    ans += hidden_num

print(ans)

