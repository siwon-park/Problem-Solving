# ABC (3047번)
import sys
input = sys.stdin.readline

lst = list(map(int, input().rstrip().split()))
lst.sort()
order = input().rstrip()
ans = ""
for c in order:
    ans += str(lst[ord(c) - 65])
    ans += " "

print(ans)

