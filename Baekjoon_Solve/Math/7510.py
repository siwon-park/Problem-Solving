# 고급 수학 (7510번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for i in range(N):
    a, b, c = map(int, input().rstrip().split())

    a2, b2, c2 = a * a, b * b, c * c
    ans = "no"
    if (a2 + b2 == c2) or (a2 + c2 == b2) or (b2 + c2 == a2):
        ans = "yes"
    else:
        ans = "no"

    print(f'Scenario #{i + 1}:')
    print(ans)
    print()

