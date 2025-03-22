import sys

input = sys.stdin.readline

# 준살 프로그래밍 대회 (7513번)
T = int(input().rstrip())
for tc in range(T):
    print(f'Scenario #{tc + 1}:')
    m = int(input().rstrip())
    words = [input().rstrip() for _ in range(m)]
    n = int(input().rstrip())
    for i in range(n):
        lst = list(map(int, input().rstrip().split()))
        k = lst[0]
        pwd = ""
        for j in range(1, k + 1):
            pwd += words[lst[j]]
        print(pwd)
    print()

