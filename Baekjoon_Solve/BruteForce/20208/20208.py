import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M, H = map(int, input().split())
board = []
arr = [] # 민트초코 좌표를 담을 리스트

for i in range(N):
    board.append(input().rstrip().split())
    for j in range(N):
        if board[i][j] == "2":
            arr.append((i, j))
        elif board[i][j] == "1":
            y, x = i, j

L = len(arr)
visited = [False] * (L) # 중복방문 방지 체크 배열

# 순열을 구성하는 재귀함수
def permute(k, m, cnt, cur_y, cur_x):
    global max_cnt
    if m < 0:
        return
    if k >= 1 and m >= 0:
        if m - (abs(cur_y - y) + abs(cur_x - x)) >= 0:
            max_cnt = max(max_cnt, cnt)
    if k == L:
        return
    for i in range(L):
        if not visited[i]:
            visited[i] = True
            m -= abs(cur_y - arr[i][0]) + abs(cur_x - arr[i][1])
            if m >= 0: # 도중에 0보다 작아지면 민트초코까지 도달할 수 없음
                m += H
                cnt += 1
                permute(k+1, m, cnt, arr[i][0], arr[i][1])
                m -= H
                cnt -= 1
            m += abs(cur_y - arr[i][0]) + abs(cur_x - arr[i][1])
            visited[i] = False

max_cnt = 0
permute(0, M, 0, y, x)
print(max_cnt)