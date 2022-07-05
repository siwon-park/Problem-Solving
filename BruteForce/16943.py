# 숫자 재배치(16943번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/16943
    # 백트랙킹
    # A의 길이만큼 C를 구성했을 때, 즉 C가 A의 모든 원소를 사용한 부분순열일 때,
    # B보다 작은 C 중에 가장 큰 C를 구하는 문제이다.
    # 크게 어려운 부분은 없었으나, 가지치기를 좀 더 효과적으로 할 수 있는 방법이 필요한 풀이이다.
    # 풀이가 그렇게 썩 맘에 들지는 않는다....
###################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

A, B = input().split()
A = list(A)
B = int(B)
N = len(A)

C = -1
visited = [False] * N
def dfs(k, num):
    global C
    if k == N:
        n = int(num)
        if len(str(n)) != N:
            return
        if n < B:
            C = max(C, n)
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            dfs(k + 1, num + A[i])
            visited[i] = False

dfs(0, '')
print(C)
