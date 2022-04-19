# 양 구출 작전(16437번)
###############################################################################################
    # 문제: https://www.acmicpc.net/problem/16437
    # 트리, DFS
    # 거의 한 2시간은 헤맸다.
    # 헤맨 이유는 간단했다. DFS를 백트랙킹 방식으로 설계해서 값의 누적으로 살아남은 양을 계산했는데, 질문 게시판을 찾아보니
    # 사실 상 늑대는 일생동안 양을 1마리만 먹는다. 따라서 노드를 지날 때 해당 노드에 기록된 숫자에 대해 한번만 계산해야 한다.
    # 또 total을 0으로 두고 어떤 노드에서 서브 트리를 다 돌고 돌아와서 양의 숫자를 카운팅 하게끔 설계를 하니
    # 방문하지 말아야할 노드의 값까지 방문하고 돌아오는 문제가 발생하였다.
    # 질문 게시판을 참고해서 문제점을 찾고 겨우 해결할 수 있었다. 아마 실제 코테에서 나왔으면 100% 틀렸을 것 같다.
    # 여전히 DFS를 설계하는데 서투른 듯하다. 특히 트리는 더욱 그렇고, 전보다는 확실히 나아졌지만 더 많은 연습이 필요하다고 생각한다.
###############################################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
isl = [0] * (N + 1)
for i in range(2, N+1):
    t, a, p = input().rstrip().split()
    a, p = int(a), int(p)
    if t == "S":
        graph[p].append(i)
        isl[i] = a
    else:
        graph[p].append(i)
        isl[i] = -a

def dfs(cur):
    total = isl[cur]
    for nxt in graph[cur]:
        total += dfs(nxt)
    if total < 0:
        total = 0
    return total

print(dfs(1))
