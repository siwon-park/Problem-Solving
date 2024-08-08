# 자기복제수 (2028번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for t in range(T):
    N = int(input().rstrip())
    pow_N = N * N
    flag = False
    if N < 10:
        if pow_N % 10 == N:
            flag = True
    elif N < 100:
        if pow_N % 100 == N:
            flag = True
    elif N < 1000:
        if pow_N % 1000 == N:
            flag = True
    if flag:
        print("YES")
    else:
        print("NO")

