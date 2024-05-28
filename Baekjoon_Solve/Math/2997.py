# 네 번째 수 (2997번)
import sys
input = sys.stdin.readline

lst = list(map(int, input().rstrip().split()))
lst.sort()
a = lst[0]
b = lst[1]
c = lst[2]
diff = min(c - b, b - a)

ans = a - diff
if a + diff != b:
    ans = a + diff
elif b + diff != c:
    ans = b + diff
print(ans)

