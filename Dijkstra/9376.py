# 탈옥(9376번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/9376
    # 다익스트라, BFS
########################################################################################
import sys, heapq
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def dijkstra(r, c):
    INF = sys.maxsize
    pq = []
    distance = [[INF for _ in range(w + 2)] for _ in range(h + 2)]
    distance[r][c] = 0
    heapq.heappush(pq, (0, r, c))
    while pq:
        d, y, x = heapq.heappop(pq)
        if distance[y][x] < d:
            continue
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < h + 2 and 0 <= nx < w + 2:
                if graph[ny][nx] == "#":
                    if d + 1 < distance[ny][nx]:
                        distance[ny][nx] = d + 1
                        heapq.heappush(pq, (d + 1, ny, nx))
                elif graph[ny][nx] == ".":
                    if d < distance[ny][nx]:
                        distance[ny][nx] = d
                        heapq.heappush(pq, (d, ny, nx))
    return distance

T = int(input())
for tc in range(T):
    h, w = map(int, input().split())
    graph = [] # 격자판(상하좌우로 한칸 씩 늘려준다)
    graph.append(["." for _ in range(w + 2)])
    p = [] # 죄수들의 좌표
    doors = [] # 문들의 좌표
    for i in range(h):
        lst = list(input().rstrip())
        for j in range(w):  # 배열에 좌표값을 넣을 때 상, 좌 하나씩 더 늘린 값인 +1을 해줌
            if lst[j] == "$":
                p.append((i + 1, j + 1))
                lst[j] = "."
            elif lst[j] == "#":
                doors.append((i + 1, j + 1))
        graph.append(["."] + lst + ["."])
    graph.append(["." for _ in range(w + 2)])

    D1 = dijkstra(p[0][0], p[0][1]) # 첫번째 죄수의 최단거리 테이블
    D2 = dijkstra(p[1][0], p[1][1]) # 두번째 죄수의 최단거리 테이블
    D3 = dijkstra(0, 0) # 중복을 고려하기 위한 최단 거리 테이블(두 죄수가 동일한 문을 열고 나간 경우)

    ans = sys.maxsize
    for y, x in doors:
        ans = min(ans, D1[y][x] + D2[y][x] + D3[y][x] - 2)

    p.append((0, 0))
    for y, x in p:
        ans = min(ans, D1[y][x] + D2[y][x] + D3[y][x])

    print(ans)
