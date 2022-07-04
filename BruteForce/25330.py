# SHOW ME THE DUNGEON(25330번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/25330
    # 브루트포스, 백트랙킹
    # 크게 어려운 부분이 없던 백트랙킹 문제이다
    # N이 최대 20보다 작거나 같으므로 충분히 백트랙킹으로 해결 가능하며, k < 0이면 더 이상 탐색을 못하도록 가지치기를 하였다.
    # 체력은 항상 이전까지 방문한 마을에 있던 몬스터의 공격력 합의 누적을 빼줘야하므로 acc라는 매개변수를 추가하였다.
###################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, K = map(int, input().split()) # 몬스터 수, 체력
A = list(map(int, input().split())) # 몬스터의 공격력
P = list(map(int, input().split())) # 각 마을의 주민

max_save = -sys.maxsize
visited = [False] * N
def dfs(k, acc, save):
    global max_save
    if k < 0:
        return
    if k >= 0:
        max_save = max(max_save, save)
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            dfs(k - acc - A[i], acc + A[i], save + P[i])
            visited[i] = False

dfs(K, 0, 0)
print(max_save)
