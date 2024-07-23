# 특정 대문자를 소문자로 바꾸기 (26040번)
import sys
input = sys.stdin.readline

A = input().rstrip()
lst = input().split()
ans = ""
for i in A:
    if i in lst:
        ans += i.lower()
    else:
        ans += i

print(ans)
