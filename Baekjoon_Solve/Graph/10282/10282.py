#해킹 (10282번)
#############################################
    # 문제: https://www.acmicpc.net/problem/10282
    # 다익스트라 알고리즘
    # a가 b를 의존한다. 그리고 b가 감염되면 a가 감염된다. 이 의미를 b → a로 연결되어 있다고 해석하면 된다.
    # 감염되는 컴퓨터 수는 최단 거리 테이블에서 INF(=int(1e9))가 아닌 정수의 개수이고, 마지막에 감염되는 컴퓨터 또한 INF가 아닌 정수의 최댓값을 의미한다.
#############################################
import sys, heapq
input = sys.stdin.readline
T = int(input())
INF = int(1e9)

# 다익스트라 최단거리 함수 선언(노드의 개수 n과 처음 감염된 컴퓨터 c, 그리고 각 테스트 케이스마다 바뀌는 2차원 배열을 변수로 입력받는다)
def dijkstra(n, c, board):
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, c))
    distance[c] = 0
    while q:
        t, cur = heapq.heappop(q)
        if distance[cur] < t:
            continue
        for nxt, nt in board[cur]:
            n_time = t + nt
            if distance[nxt] > n_time:
                distance[nxt] = n_time
                heapq.heappush(q, (n_time, nxt))
    return distance


for i in range(T):
    n, d, c = map(int, input().split())
    board = [[] for _ in range(n + 1)]
    for _ in range(d):
        a, b, s = map(int, input().split()) # 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨
        board[b].append((a, s)) # 여기서 주의! a,b,s 순으로 입력받았지만, 연결 관계는 b → a가 되게끔 board[b].append((a,s))로 쓴다
    dst = dijkstra(n, c, board)
    count = 0
    total = 0
    for r in dst[1:]:
        if r != INF:
            count += 1
            total = max(total, r)
    print(count, total)     
