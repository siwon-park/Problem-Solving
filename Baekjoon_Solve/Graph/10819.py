# 차이를 최대로(10819번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/10819
    # 백트랙킹, 순열
    # 백트랙킹으로 순열을 구현하여 문제를 해결하였다.
    # 빠르게 푼 사람들의 풀이를 보니 백트랙킹이 아니라 반복문으로 완전탐색하여 해결하였다.
    # 푸는 도중에 함수가 끝나지 않는 문제가 있었는데 보니까 for 구문 안에서 k부터 출발하게 했어야했는데, 아무 인자를 넣지 않고 있었다.
###################################################################
import sys
input = sys.stdin.readline

def dfs(k):
    global max_sum
    if k == N:
        ssum = 0
        for j in range(N-1):
            ssum += abs(A[j]-A[j+1])
        if ssum > max_sum:
            max_sum = ssum
        return
    else:
        for i in range(k, N):
            A[i], A[k] = A[k], A[i]
            dfs(k+1)
            A[i], A[k] = A[k], A[i]

N = int(input())
A = list(map(int, input().split()))
max_sum = -int(1e9)
dfs(0)
print(max_sum)
