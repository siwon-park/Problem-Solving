# 지구 온난화(5212번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/5212
    # 시뮬레이션, 구현
    # 어려운 문제는 아닌데, 처음에 예제 2번이 이해가 안 갔다. 그래서 질문 게시판을 보니까 이해를 할 수 있었고
    # 자세히 보니 문제에 조건이 나와있긴 했다. 좀 더 꼼꼼히 읽지 못한 내 실책이다.
    # 마지막에 지도를 자를 때는 섬이 있는 행과 열의 최소, 최댓값을 활용하여 자르는 방식으로 구현하였다.
#####################################################################################
import sys
input = sys.stdin.readline

R, C = map(int, input().split())
board = [list(input().rstrip()) for _ in range(R)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

lst = []
for i in range(R):
    for j in range(C):
        if board[i][j] == "X":
            cnt = 0
            for dy, dx in dydx:
                ny, nx = i + dy, j + dx
                # 지도 밖이거나 "."이면 모두 바다임
                if 0 <= ny < R and 0 <= nx < C and board[ny][nx] == ".":
                    cnt += 1
                elif ny < 0 or ny >= R or nx < 0 or nx >= C:
                    cnt += 1
            if cnt >= 3:
                lst.append((i, j))

for r, c in lst:
    board[r][c] = "."

# 지도를 자름(최댓값 최솟값 기준으로 자른다)
min_r, max_r, min_c, max_c = int(1e9), -int(1e9), int(1e9), -int(1e9)
for r in range(R):
    for c in range(C):
        if board[r][c] == "X":
            min_r = min(min_r, r)
            max_r = max(max_r, r)
            min_c = min(min_c, c)
            max_c = max(max_c, c)

for r in range(min_r, max_r + 1):
    print("".join(board[r][min_c:max_c + 1]))
