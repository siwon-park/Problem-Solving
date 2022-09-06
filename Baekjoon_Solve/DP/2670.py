# 연속부분최대곱(2670번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/2670
    # DP
    # 다 풀었는데 4번이나 틀려서 왜인가 봤더니
    # 최종적으로 출력하는 것에서만 소숫점 넷째자리에서 반올림해서 셋째자리까지 출력하면 되는 것이었다...
#############################################################################
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = [0]
for _ in range(N):
    lst.append(float(input().rstrip()))

dp = [0] * (N + 1)
for i in range(1, N + 1):
    dp[i] = max(lst[i], dp[i - 1] * lst[i])

print(f'{max(dp):.3f}')
