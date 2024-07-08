# 문자열 압축 해제 (23746번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
str_dict = dict()
for _ in range(N):
    p, w = input().rstrip().split()
    str_dict[w] = p

compact = input().rstrip()
s, e = map(int, input().rstrip().split())

ans = ""
for w in compact:
    ans += str_dict[w]

# ans = "".join(map(str, [str_dict[i] for i in compact]))
print(ans[s - 1:e])

