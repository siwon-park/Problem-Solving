# 나무 탈출 (15900번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/15900
    # 트리, DFS
    # 리프 to 루트까지의 거리 합이 홀수면 성원이가 이길 수 있고, 짝수면 뭔 짓을 해도 성원이는 이길 수 없다.
    # 양방향 그래프로 연결하면서 루트 노드를 제외하고, 자식 노드 수가 1이면 그 노드는 리프 노드이다.
    # dfs 탐색을 하여 루트에서 자식 노드까지의 깊이를 구한 다음 리프 노드일 경우에만 더 하여 그 결과에 따라 답을 출력하였다.
    # bottom-up dp로 풀려고했는데 틀렸습니다를 받아서 많이 헤멨다...
##########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
tree = [[] for _ in range(N + 1)]
tree_node = dict()
for _ in range(N - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)
    tree_node[a] = tree_node.get(a, 0) + 1
    tree_node[b] = tree_node.get(b, 0) + 1

# 리프 to 루트의 합이 짝수면 No, 홀수면 Yes
visited = [False] * (N + 1)
depth = [0] * (N + 1)

def dfs(d, cur):
    visited[cur] = True
    for nxt in tree[cur]:
        if not visited[nxt]:
            depth[nxt] = d + 1
            dfs(d + 1, nxt)

dfs(0, 1)

ans = 0
for i in range(2, N + 1):
    if tree_node[i] == 1:
        ans += depth[i]

if ans % 2:
    print("Yes")
else:
    print("No")

########################## bottom-up DP ########################
# bottom-up dp로 풀어보았다
# 탐색 중 루트에 대해서만 예외처리를 해주니까 이상없이 통과할 수 있었다. 루트의 높이를 1로 잡으니까 바텀업을 하더라도 누적된 값이 꼬여서 틀렸던 것 같다.
# 유의미한 시간차가 없어서 이게 DP로 올바르게 푼 게 맞나 싶기도 하다...
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
tree = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

# 리프 to 루트의 합이 짝수면 No, 홀수면 Yes
visited = [0] * (N + 1)


def dfs(d, cur):
    if visited[cur]:
        return d
    visited[cur] = d
    dist = 0
    for nxt in tree[cur]:
        if not visited[nxt] and nxt != 1:
            dist += dfs(d + 1, nxt)
    visited[cur] = max(dist, visited[cur])
    return visited[cur]

dfs(0, 1)

if visited[1] % 2:
    print("Yes")
else:
    print("No")
