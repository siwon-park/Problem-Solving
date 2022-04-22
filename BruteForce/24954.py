# 물약 구매(24954번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/24954
    # 브루트포스
    # 백트랙킹으로 완전탐색을 구현하였다.
    # 어떤 물약을 하나 샀을 때, 다른 물약들의 가격이 낮춰지는 것을 그래프라고 생각하고 접근하였다.
    # 순열을 구하는 백트랙킹을 기반으로 하였으며, 원소를 하나 선택했을 때 일단 C배열을 하나 복사하고
    # 원본 C에서 할인되는 값들로 변경해주었고, 백트랙킹을 나와서 다른 요소를 선택했을 때
    # 복사한 배열을 토대로 값을 원상복구해주었다. 복사한 배열을 활용한 이유는 어떤 물약이 할인을 받는다고 할 때
    # 그 관계가 1:1의 관계가 아닐 수도 있기 때문이다. 
    # 그래서 물약의 가격이 이미 1인 상태라서 갱신이 안 됐는데 할인받기 전으로 돌리면 안 되므로 그렇게 구현하였다.
    # 또한 현재까지 누적된 값이 최솟값보다 크면 더 탐색해봤자 소용없으므로 가지치기를 해줬다.
    # 65%에서 시간이 너무 오래 걸리기 시작했다. Python3로는 7560ms으로 통과할 수 있었다.
################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
C = list(map(int, input().split()))

graph = [[] for _ in range(N)]
for i in range(N):
    p = int(input())
    for j in range(p):
        a, d = map(int, input().split())
        graph[i].append((a - 1, d))

visited = [False] * (N + 1)
min_total = sum(C)

def dfs(k, cur_total):
    global min_total
    if min_total < cur_total:
        return
    if k == N:
        if cur_total < min_total:
            min_total = cur_total
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            tmp_c = C[:]
            for nxt, d in graph[i]:
                C[nxt] -= d
                if C[nxt] <= 0:
                    C[nxt] = 1
            dfs(k+1, cur_total + C[i])
            for nxt, d in graph[i]:
                if C[nxt] != tmp_c[nxt]:
                    C[nxt] = tmp_c[nxt]
            visited[i] = False

dfs(0, 0)
print(min_total)
