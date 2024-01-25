# AFC 윔블던 (4299번)
import sys
input = sys.stdin.readline

a, b = map(int, input().rstrip().split())  # a = x + y, b = x - y
x = (a + b) // 2
y = (a - b) // 2
if a != x + y or b != x - y or a < b or y < 0:
    print(-1)
else:
    print(x, y)

