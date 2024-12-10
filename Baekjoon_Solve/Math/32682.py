# Which Number Kind Is It? (32682번)
import math
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for t in range(T):
    n = int(input().rstrip())
    sqrt = int(math.sqrt(n))
    ans = ""
    if n % 2:
        ans = "O"
        if sqrt ** 2 == n:
            ans += "S"
    elif sqrt ** 2 == n:
        ans = "S"
    else:
        ans = "EMPTY"
    print(ans)

