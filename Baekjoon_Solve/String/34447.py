# Bad Directions (34447번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for tc in range(T):
    k, n = map(int, input().rstrip().split())
    ans = ""
    l = len(str(n))
    while n > 0:
        r = n % 10
        n //= 10
        ans += str((r + k) % 10)

    m = len(ans)
    if m < l:
        print("0" * (l - m) + ans[::-1])
    else:
        print(ans[::-1])

