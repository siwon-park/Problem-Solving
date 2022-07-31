# 탈옥(9376번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/9376
    # 다익스트라, BFS
    # 이 문제를 풀려면 몇 가지 스킬이 필요하다.
    # 첫번째, 배열을 상하좌우로 1칸씩 늘린다.
    # 두번째, 각 죄수의 최단거리 테이블과 (0, 0)에서 출발한 즉, 둘이 같이 이동한 경우에 대한 최단거리 테이블을 구한다
    # 세번째, 각 문의 위치와 각 죄수의 출발 위치 그리고 (0, 0)에 대해서 3개의 최단 거리 테이블에 기록된 값을 활용해 문을 연 최소 횟수를 구한다
    # 이때, 문에 대해서는 3개의 최단 거리 테이블 값을 더한 값에 - 2를 해준다. 중복을 제거하기 위함임
    # 최단 거리를 구하는 데 전혀 상관없는 문은 어차피 더해봤자 그 값이 크기 때문에 상관없다.
    # 각 죄수의 위치와 (0, 0)에 대해서는 3개의 최단 거리 테이블의 값을 더해준 값을 사용한다.
    # (0, 0)에서 출발한 것이 왜 공통으로 연 경우가 되는 이유는
    # 일단 각 죄수가 개별적으로 출발해서 가다가 공통으로 열어야 되는 문을 만났으면,
    # 거기서 부터 열어야하는 문의 개수는 그 위치까지 밖(0, 0)에서 출발해서 온 문의 개수이기 때문이다.
    # 따라서 문의 경우에 대해서 3개의 최단 거리 테이블 값을 더한 값에 - 2(밖에서 온 경우의 값에 각 죄수가 개별적으로 여는 경우를 뺌)를 해준다는 것이다.
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
