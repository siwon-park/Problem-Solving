# 숫자 이어 붙이기(24955번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/24955
    # DFS
    # 메모이제이션으로 풀었다. 메모이제이션 배열 및 DFS탐색이기에 BFS보다 메모리나 속도면에서 비효율적이다.
    # 빠른 풀이의 메모리 사용량 및 풀이시간을 볼 때 BFS로 풀었을 것이다.
    # memo[r][c] = r에서 출발해서 c에 도착했을 때의 숫자 모양을 기록했다.
    # 매번 DFS를 돌리면서 int(1e9)+7로 나눈 나머지를 계산하는게 비효율적인 것 같아서
    # 마지막에 나눠주는 방법으로 시도해봤는데, 어느정도 짐작한대로 메모리 초과 판정을 받았다.
    # 문자열의 길이가 너무 길어져서 int형으로 바꿔서 계산했을 시 오버헤드가 났을 것이다.
###############################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N, Q = map(int, input().split()) # 집의 수, 놀이 수
A = input().split() # 집에 붙어있는 숫자의 번호
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

query = []
for _ in range(Q):
    x, y = map(int, input().split())
    query.append((x, y))

memo = [[0] * (N + 1) for _ in range(N + 1)] # r출발 c도착 했을 때 만들어지는 숫자

def dfs(frm, to, s):
    global x, y
    if memo[frm][to]:
        return memo[frm][to]
    memo[frm][to] = s
    for nxt in graph[to]:
        dfs(frm, nxt, str(int(s+A[nxt - 1]) % (int(1e9) + 7)))

for i in range(1, N+1):
    dfs(i, i, A[i-1])

# for x, y in query:
#     print(memo[x][y])
