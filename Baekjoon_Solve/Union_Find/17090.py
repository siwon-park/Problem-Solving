# 미로 탈출하기(17090번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/17090
    # 분리집합, (DFS, 다이나믹 프로그래밍)
    # DFS와 다이나믹 프로그래밍을 통해 푸는 문제인데 분리집합으로 풀어도 될 것 같아서 분리집합으로 풀었다
    # 2차원의 배열에 1부터 N*M까지 노드 번호를 매겼다.
    # 그렇게 하기 위해서 (N + 2) * (M + 2) 배열을 선언하여 인덱스 1부터 N+1, M + 1까지 탐색하여 N*M까지 노드 번호를 기록했다
    # 만약 밖으로 나갈 수 있다면 최종적으로 0번 노드와 연결되므로 부모 노드의 번호가 0이된다.
    # 따라서 1부터 N까지 부모 노드를 탐색해서 0번 노드가 부모 노드이면 그 칸에서는 탈출할 수 있는 것이므로 cnt += 1을 해주었다.
    # 처음에 마지막에 1 ~ N까지 find를 호출하지 않고 답을 계산해내는 로직으로 구현하고자 했는데
    # 잘 안 돼서 그냥 1부터 N까지의 부모 노드를 일일히 다 갱신/확인했다. => 조금 비효율적이라고 생각해서 고치고 싶다.
##############################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

dydx = {"U": (-1, 0), "D": (1, 0), "R": (0, 1), "L": (0, -1)}
parent = [i for i in range(N * M + 1)] # 부모 배열 N*M까지

PT = [[0 for _ in range(M + 2)] for _ in range(N + 2)] # (N + 2) * (M + 2) 배열을 만듦

# PT에 노드 번호를 표시함
n = 1
for i in range(1, N + 1):
    for j in range(1, M + 1):
        PT[i][j] = n
        n += 1

cnt = 0
for y in range(N):
    for x in range(M):
        dy, dx = dydx[board[y][x]]
        ny, nx = y + dy, x + dx
        a = PT[y + 1][x + 1] # 현재 노드 번호
        b = PT[ny + 1][nx + 1] # 다음 이동할 위치의 노드 번호
        if find(a) != find(b):
            union(a, b)

# print(parent)

for i in range(1, N*M + 1):
    if not find(i):
        cnt += 1
        
print(cnt)
