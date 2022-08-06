# 통나무 옮기기(1938번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/1938
    # BFS, 시뮬레이션
    # BFS로 문제를 해결하였지만, BFS를 하는 것보다 구현이 더 비중이 높다고 생각해서 구현문제로 분류함
    # 4차원의 배열을 사용하였음 y좌표, x좌표, 방향, 모양
    # 처음부터 이런 식으로 구상해서 구현한 것은 아니고 문제를 풀면서 보니까 어떤 모양으로 해당 방향에서 왔는지 체크하는 것이 필요하다는 것을 깨닫고
    # 4차원의 배열을 사용하였다.
    # 로직 자체는 어려운 편에 속하진 않는다고 생각하나, 조건에 따른 세부 구현이 조금 신경써야하는 편인 것 같다. 예를 들면, flag와 move 변수를 사용한 것처럼
    # 그리고 무조건 방문할 수 있다고 방문을 체크하는 것이 아니라 3칸의 통나무 칸 중 어느 하나라도 다음 좌표로 방문하지 않거나 더 짧은 횟수로 방문이 가능하다면
    # 3칸 모두 다음 방문 좌표로 갱신해주었다.
    # 14%에서 틀렸습니다를 받았는데, 질문 게시판에 어느 한 반례를 보고 내가 어디서 틀렸는지 알 수 있었다.
    # 사실 이 부분을 처음엔 염두해뒀으나, 괜찮을 것이라 판단하고 구현하지 않았더니 문제가 되었다.
    # 좌표를 회전했을 때, 회전 후 큐에 담기 직전에 정렬을 해줬어야 했는데, 그렇게 하지 않았다. 사실 처음엔 정렬이 필요할 것 같다 했지만
    # 괜찮을 것이라 생각한 이유가 어차피 맨처음 통나무 좌표를 3개 받을 때, 순차적으로 받을 것이니까 가운데 축의 좌표만 잘 유지된다면 정렬은 크게 필요없을 것이라고 생각했다.
    # 그래서 축을 회전시켜도 항상 순차 좌표를 유지할 것이라 생각했는데, 코드 상에서 그렇게 동작하지 않는 것을 발견하고 바로 정렬을 적용해주었다.
###############################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
q = deque()
blst, elst = [], []
board = []
INF = sys.maxsize
visited = [[[[INF, INF] for _ in range(5)] for _ in range(N)] for _ in range(N)]

for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(N):
        if board[i][j] == "B":
            blst.append((i, j))
            # visited[i][j] = [True] * 5
            board[i][j] = "0"
        elif board[i][j] == "E":
            elst.append((i, j))
            board[i][j] = "0"
# 현재 통나무의 모양 판별
if blst[0][0] == blst[1][0]:
    shape = 0
else:
    shape = 1

q.append((0, shape, blst)) # cnt, 모양, B좌표 3개

dydx = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, 1), (1, -1)]

def check(y, x):
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < N and board[ny][nx] == "1":
            return False
        elif ny < 0 or ny >= N or nx < 0 or nx >= N:
            return False
    return True

def bfs():
    while q:
        cnt, s, blst = q.popleft()
        # print(cnt, s, blst, elst, "====================sdsdss====")
        if set(blst) == set(elst):
            return cnt
        # 상하좌우 이동 체크
        for k in range(4):
            dy, dx = dydx[k][0], dydx[k][1]
            flag = 0 # 통나무 이동 가능 flag 변수
            move = 0
            tmp_blst = []
            for y, x in blst:
                ny, nx = y + dy, x + dx
                if 0 <= ny < N and 0 <= nx < N and board[ny][nx] == "0":
                    if cnt + 1 < visited[ny][nx][k][s]:
                        flag = 1
                    tmp_blst.append((ny, nx))
                    move += 1
            if flag and move == 3:
                # print(blst, tmp_blst, "=======================", cnt, move, flag)
                for r, c in tmp_blst:
                    visited[r][c][k][s] = cnt + 1
                q.append((cnt + 1, s, tmp_blst))
        # 90도 회전
        flag = 0
        move = 0
        tmp_blst = []
        y1, x1 = blst[0][0], blst[0][1]
        y3, x3 = blst[1][0], blst[1][1]
        y2, x2 = blst[2][0], blst[2][1]
        # 3*3배열에 아무것도 없으면 이동 가능
        if check(y3, x3):
            s = 0 if s == 1 else 1
            # x축이 모두 같으면
            if x1 == x2 and x1 == x3 and x2 == x3:
                ny1, nx1, ny2, nx2 = y1 + 1, x1 + 1, y2 - 1, x2 - 1
                if 0 <= ny1 < N and 0 <= nx1 < N:
                    if cnt + 1 < visited[ny1][nx1][4][s]:
                        flag = 1
                    tmp_blst.append((ny1, nx1))
                    tmp_blst.append((y3, x3))
                    move += 1
                if 0 <= ny2 < N and 0 <= nx2 < N:
                    if cnt + 1 < visited[ny2][nx2][4][s]:
                        flag = 1
                    tmp_blst.append((ny2, nx2))
                    move += 1
            # y축이 모두 같으면
            elif y1 == y2 and y1 == y3 and y2 == y3:
                ny1, nx1, ny2, nx2 = y1 - 1, x1 + 1, y2 + 1, x2 - 1
                # print(ny1, nx1)
                if 0 <= ny1 < N and 0 <= nx1 < N:
                    if cnt + 1 < visited[ny1][nx1][4][s]:
                        flag = 1
                    tmp_blst.append((ny1, nx1))
                    tmp_blst.append((y3, x3))
                    move += 1
                if 0 <= ny2 < N and 0 <= nx2 < N:
                    if cnt + 1 < visited[ny2][nx2][4][s]:
                        flag = 1
                    tmp_blst.append((ny2, nx2))
                    move += 1
            # print(cnt, blst, tmp_blst, "회전 전", move, flag)
            if flag and move == 2:
                # print(cnt, tmp_blst, "회전함")
                for r, c in tmp_blst:
                    visited[r][c][4][s] = cnt + 1
                tmp_blst.sort() # 정렬을 해줘야 다음 번에도 올바르게 회전
                q.append((cnt + 1, s, tmp_blst))

    return 0

print(bfs())
