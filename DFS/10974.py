# 모든 순열(10974번)
##########################################################
    # 문제: https://www.acmicpc.net/problem/10974
    # 백트랙킹
    # 일반적인 순열을 구하는 문제, 백트랙킹으로 구현하였음
##########################################################
import sys
input = sys.stdin.readline

def permute(k, lst):
    if k == N:
        print(*lst)
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            permute(k+1, lst+[arr[i]])
            visited[i] = False

N = int(input())
arr = list(range(1, N+1))
visited = [False] * N
permute(0, [])
