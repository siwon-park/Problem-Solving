# 0의 개수(11170번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/11170
    # 브루트포스
    # 효율성은 그리 좋지 않은 것 같다.
    # dp의 개념을 일부 활용해서 풀면 더 빠르게 풀 수 있는 것 같다.
    # 예를 들면, dp[101] = dp[10] + dp[1]로 점화식을 세운다면 dp[i] = dp[i//10] + dp[i%10]이 된다.
    # 이를 활용하면 더 빠른 계산이 가능하다.
######################################################################
import sys
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    N, M = map(int, input().split())
    cnt = 0
    for num in range(N, M+1):
        cnt += str(num).count("0")
    print(cnt)
