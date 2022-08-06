# 북쪽나라의 도로(1595번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/1595
    # 트리, DFS
    # 트리의 지름을 구하는 문제
    # 이 문제가 트리인 이유는 문제에 나와있는 지문에서 
    # "특정 도시를 두 번 이상 지나가지 않고서 임의의 두 도시간을 이동하는 경로가 유일하도록 도로가 설계되어 있다"고 했는데,
    # 이 말의 의미는 사이클이 존재하지 않는다는 의미이면서, 두 도시 간 유일한 경로가 존재한다는 것이므로 트리이다.
    # 트리의 지름은 먼저 아무 노드에서 출발해서 그 노드에서 가장 먼 거리를 구한 뒤,
    # 구한 가장 먼 거리의 노드에서 다시 가장 먼 거리까지의 거리를 구하면 된다.
###################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(cur, d):
    global max_dist, far_node
    if visited[cur] < d:
        return
    visited[cur] = d
    if max_dist < d:
        max_dist = d
        far_node = cur
    for nxt, cost in graph[cur]:
        if d + cost < visited[nxt]:
            dfs(nxt, d + cost)

graph = [[] for _ in range(10001)]
while True:
    try:
        a, b, cost = map(int, input().split())
        graph[a].append((b, cost))
        graph[b].append((a, cost))
    except:
        break

# 어떤 노드에서 가장 먼 거리에 있는 노드를 구함
INF = int(1e9)
visited = [INF] * 10001
far_node = 0
max_dist = 0
dfs(1, 0)

# 가장 먼 거리에 있는 노드에서 가장 멀리 떨어진 노드에 대한 거리를 구함
visited = [INF] * 10001
dfs(far_node, 0)
print(max_dist)
