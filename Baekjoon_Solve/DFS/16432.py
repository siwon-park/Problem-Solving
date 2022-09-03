# 떡장수와 호랑이(16432번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/16432
    # DFS
    # 단순 백트랙킹으로만 푼다면, 8^n의 시간이 걸리므로 가지치기를 잘 해줘야한다.
    # visited[n번째날][m번 떡을 줌]을 통해 방문을 체크한다.
    # 여기서 중요한 것이, if not visited[n + 1][dduk]: 과 같은 조건으로만 비교하면 오래 걸리는 케이스가 있다
    # 왜냐하면, n + 1번째 날에는 해당 dduk이 없어서 dduk을 줄 수 없어서 False인데,
    # 마치 줄 수 있는데도 안 줬던 것처럼 되어버리기 때문에 그렇다.
    # 그래서 m이라는 전날 줬던 떡을 매개변수로 주고, 현재 줄 수 있는 떡과 다르고, 
    # 현재 그 떡을 방문하지 않았으면, DFS탐색을 계속하는 방식으로 탐색한다.
#########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [[]]
for i in range(N):
    lst = list(map(int, input().split()))
    graph.append(lst[1:])

visited = [[False] * 10 for _ in range(N + 1)]

flag = False
def dfs(n, m, lst):
    global flag
    if n == 0:
        for dduk in lst[::-1]: # N부터 출발했으므로, 1일차부터 출력하려면 뒤집어 줘야한다.
            print(dduk)
        flag = True
        return
    for dduk in graph[n]:
        if m != dduk and not visited[n][dduk]: # if not visited[n + 1][dduk]: 과 같은 조건으로만 비교하면 오래 걸리는 케이스가 존재함
            visited[n][dduk] = True
            dfs(n - 1, dduk, lst + [dduk])
            if flag:
                return

dfs(N, 0, [])

if not flag:
    print(-1)
