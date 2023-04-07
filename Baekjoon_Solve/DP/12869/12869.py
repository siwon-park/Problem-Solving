import sys
input = sys.stdin.readline

N = int(input().rstrip())
I, J, K = 0, 0, 0
lst = list(map(int, input().rstrip().split()))
if len(lst) == 1:
    I = lst[0]
elif len(lst) == 2:
    I, J = lst[0], lst[1]
else:
    I, J, K = lst[0], lst[1], lst[2]

dp = [[[10001 for _ in range(61)] for _ in range(61)] for _ in range(61)]
attack = [(9, 3, 1), (9, 1, 3), (1, 3, 9), (3, 1, 9), (1, 9, 3), (3, 9, 1)]

dp[0][0][0] = 0
for i in range(61):
    for j in range(61):
        for k in range(61):
            for a, b, c in attack:
                i1, i2, i3 = i - a, j - b, k - c
                if i1 < 0:
                    i1 = 0
                if i2 < 0:
                    i2 = 0
                if i3 < 0:
                    i3 = 0
                dp[i][j][k] = min(dp[i1][i2][i3] + 1, dp[i][j][k])

print(dp[I][J][K])