# 트리 색칠하기(24230번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/24230
    # DFS, 트리
    # 처음에 뭔가 다른 게 있을 줄 알았는데, 곰곰히 생각해보니 일반적으로 DFS로 노드를 방문을 하는 문제였다.
    # 정말 사소한 실수를 해서 2번 틀렸습니다를 받았다.
    # 방문 인덱스를 잘못 지정해줬고, C[i]가 0이 아닐 때 카운트를 했어야 했는데 C[i]가 0일 때 카운트를 하고 있었다.
    # 부모 노드를 칠하면 그 아래 서브 트리도 같은 색으로 칠해지므로,
    # BFS에서 영역의 개수, 연결 컴포넌트의 개수를 구하는 문제와 같은 로직으로 풀 수 있다.
    # 연결 컴포넌트를 구성하고 나서 C[i]가 0이 아닐 경우에만 카운트를 해주면 된다. 
#########################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N = int(input())
C = list(map(int, input().split()))
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)

def dfs(cur, color):
    visited[cur] = True
    for nxt in graph[cur]:
        if not visited[nxt] and C[nxt-1] == color: # 방문하지 않았고 색이 같을 경우에만 DFS 탐색
            dfs(nxt, color)

cnt = 0
for i in range(N):
    if not visited[i+1]: # visited[i]라고 해서 틀렸음
        dfs(i+1, C[i])
        if C[i]: # not C[i]로 해서 틀렸음
            cnt += 1

print(cnt)
# print(visited)
