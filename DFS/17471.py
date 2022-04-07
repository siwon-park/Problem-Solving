# 게리맨더링(17471번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/17471
    # DFS, BFS
    # 특이하게 DFS와 BFS를 둘 다 사용해야 풀 수 있었던 문제이다.
    # 먼저, DFS를 통해서 Subset(부분집합)을 중복없이 구하는 함수를 만든다.
    # 여기서 말하는 중복없음이란 [0], [1, 2, 3, 4, 5] 일 때, [1, 2, 3, 4, 5], [0] 이렇게 서로 대칭되는 구조가 나오지 않는 것을 말한다.
    # 이 두 개는 결과가 같아서 사실상 같으므로 1개로 쳐야한다.
    # 그리고 두 구역의 개수의 합이 N개 일 때, BFS함수를 돌려서, 구역과 그 구역에 대한 합을 구한다.
    # 구역의 크기가 1로 나와야만 해당 구역은 서로 연결되어 있는 구역이다. 2 이상이 나오면 어딘가 떨어져 있다는 의미이다.
    # 따라서 A와 B 영역의 크기가 1일 때만 선거구의 합의 차이에 대한 최솟값을 구한다.
######################################################################
import sys
from collections import deque
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
regions = list(map(int, input().split()))
R = sum(regions)
graph = [[] for _ in range(N)]
for i in range(N):
    info = list(map(int, input().split()))
    for j in range(info[0]):
        graph[i].append(info[j+1]-1)
        
INF = sys.maxsize
min_diff = sys.maxsize

# BFS
def bfs(lst):
    area = 0 # 구역의 크기
    area_sum = 0 # 구역의 합
    visited = [False]*N
    for s in lst:
        if not visited[s]:
            visited[s] = True
            area += 1
            q = deque([s])
            while q:
                cur = q.popleft()
                area_sum += regions[cur]
                for nxt in graph[cur]:
                    if not visited[nxt] and nxt in lst: # 방문하지 않았으면서, 현재 같은 부분집합 셋에 있을 경우에만 방문
                        q.append(nxt)
                        visited[nxt] = True
    return area, area_sum # 구역의 크기와 구역의 합을 반환

A = [0] # A에 0을 넣고 부분집합을 구함으로써 중복을 제거할 수 있다.
B = [] # 왜냐하면 A에 0부터 넣고 시작했으니, B에는 절대 0이 들어갈 수 없어서 0부터 시작해서 만드는 조합셋을 가질 수가 없기 때문이다.
# 부분집합을 구하는 함수
def subset(k):
    global min_diff
    if k == N:
        if not B:
            return
        a1, sum1 = bfs(A)
        a2, sum2 = bfs(B)
        if a1 == 1 and a2 == 1: # 각 구역의 크기가 1일 때만 구역의 합의 차이의 최솟값을 계산 및 갱신한다.
            min_diff = min(min_diff, abs(sum1 - sum2))
        return
    else:
        # k를 A에 포함
        A.append(k)
        subset(k+1)
        A.pop()
        # k를 B에 포함
        B.append(k)
        subset(k+1)
        B.pop()

subset(1)

if min_diff == sys.maxsize:
    print(-1)
else:
    print(min_diff)
