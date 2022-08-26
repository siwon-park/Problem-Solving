# 서울 지하철 2호선(16947번)
######################################################################################################
    # 문제: https://www.acmicpc.net/problem/16947
    # BFS, DFS
    # 풀이가 비효율적이라고 생각하고 풀었는데, 예상대로 그리 효율적인 풀이는 아니었다.
    # 각 노드별로 DFS를 돌려서 순환선에 해당하면 visited에 True를 체크한다.
    # 그후 각 노드별로 BFS를 돌려서 순환선까지의 최단 거리를 구한다.
    # 효율적인 풀이는 DFS, BFS를 딱 한번씩만 돌리고 있었다.(코드를 자세히 파악하지 못해서 아래에 참고 코드만 올림)
    # DFS를 돌려서 순환선을 찾는데, 사이클이면서 해당 순환선에 속하면 따로 표시를 하고, 사이클의 시작 노드를 찾아낸다.
    # BFS를 돌릴 때는 순환선에서 출발해서 순환선이 아닌 곳까지의 최단 거리를 이전 거리 + 1의 형식으로 찾는다.
    # 효율적인 풀이를 보니 내가 2번이나 비효율적으로 연산을 하고 있었음을 알게되었다.
######################################################################################################
import sys
from collections import deque
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]

distance = [0] * (N + 1)
visited = [False] * (N + 1) # 순환선이면 True

for _ in range(N):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(start, cur, tmp_visited):
    tmp_visited[cur] = True
    for nxt in graph[cur]:
        if not tmp_visited[nxt]:
            dfs(start, nxt, tmp_visited)
        elif start == cur and tmp_visited[start]: # 순환이면
            return False
    return True

# 순환선 찾기
for i in range(1, N + 1):
    tmp_visited = [False] * (N + 1)
    ret = dfs(i, i, tmp_visited)
    if not ret:
        visited[i] = True # 순환선 표시

def bfs(q, start):
    while q:
        d, cur = q.popleft()
        if visited[cur]:
            distance[start] = d
            return
        for nxt in graph[cur]:
            if not tmp_visited[nxt]:
                tmp_visited[nxt] = True
                q.append((d + 1, nxt))

# 순환선까지 최단 거리 찾기
for i in range(1, N + 1):
    tmp_visited = [False] * (N + 1)
    q = deque([(0, i)])
    tmp_visited[i] = True
    bfs(q, i)

print(*distance[1:])

#################################################################################################
def dfs(x: int, p: int):
    """사이클을 찾는 함수
    -2 : 사이클 찾음(순환선에 속하지 않음)
    -1 : 사이클을 찾지 못함
    2 : 사이클 찾음(순환선에 속함)

    이미 방문했던 노드면 사이클이다.
    사이클의 시작 노드이면 해당 노드 반환
    """
    if check[x] == 1:
        return x

    check[x] = 1 # 방문 처리
    # dfs 수행
    for y in a[x]:
        if y == p: continue # 이전 노드와 같으면 반복 건너뛰기
        res = dfs(y, x)
        if res == -2: return -2 # 사이클이지만, 순환 노드에 포함되지 않음
        if res >= 0: # 순환 노드에 포함됨
            check[x] = 2
            if x == res:
                return -2 # 사이클의 시작 노드로 돌아왔으면 -2 반환 # 사이클 시작 전의 재귀는 순환선이 아니다.
            else:
                return res
            
    return -1
