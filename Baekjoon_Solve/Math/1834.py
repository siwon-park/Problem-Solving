import sys

input = sys.stdin.readline

# 나머지와 몫이 같은 수 (1834번)
N = int(input().rstrip())
ans = (N + 1) * (N - 1) * N // 2
# for i in range(1, N):
#     ans += i * (N + 1)

print(ans)

