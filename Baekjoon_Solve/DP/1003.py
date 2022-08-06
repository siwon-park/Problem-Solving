# 피보나치 함수(1003번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/1003
    # DP, 재귀
    # 메모이제이션을 통해서 풀었다.
    # N의 0, 1이 등장한 횟수는 N - 2의 0, 1 등장횟수, N - 1의 0, 1 등장 횟수이다.
    # memo[N]에는 N일 때 0과 1이 등장한 횟수의 합이 담겨 있다.
    # 단, N이 0이나 1일 때는 각자 자기 자신의 등장 횟수가 기록되어 있다.
    # N = 2일 때, 0과 1의 등장횟수는 각 각 memo[0], memo[1]에 담겨있고,
    # 이를 재귀적으로 사용하면 N일 때 0과 1의 등장횟수는 memo[N - 2], memo[N - 1]에 담겨있다.
#######################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def fibo(n):
    if n <= 1:
        memo[n] = 1
        return memo[n]
    if memo[n]:
        return memo[n]
    memo[n] = fibo(n - 1) + fibo(n - 2)
    return memo[n]

T = int(input())
for tc in range(T):
    memo = [0] * 41
    N = int(input())
    fibo(N)
    if N == 0 or N == 1:
        print(memo[0], memo[1])
    else:
        print(memo[N - 2], memo[N - 1])
