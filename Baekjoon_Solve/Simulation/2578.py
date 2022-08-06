# 빙고(2578번)
###################################################
    # 문제: https://www.acmicpc.net/problem/2578
    # 구현
    # 코드를 더 간결하고 짧게 짜야겠다는 생각이 든다. 또한 별거 아닌 부분에서 실수해서 시간을 많이 잡아 먹어서 조금 많이 아쉽다.
    # 2번 틀렸는데, 틀린 이유는 2가지였음. 1) while q 구문을 도는 동안 cnt가 13이상일 때만 check()하게 하였으나, 최소 12번으로도 빙고가 될 수 있었음
    # 2) 행이 빙고거나, 열이 빙고일 때, 서로 다른 각 행, 각 열별로 빙고일 수도 있으므로 +=1을 해줬어야 했는데, 그냥 check_arr를 1로만 하였음.
###################################################
import sys
from collections import deque
input = sys.stdin.readline

def check():
    crs_cnt, r_crs_cnt = 0, 0
    check_arr = [0, 0, 0, 0]
    for i in range(5):
        if board[i][i] == 0:
            crs_cnt += 1
        if board[i][4-i] == 0:
            r_crs_cnt += 1
    if crs_cnt == 5:
        check_arr[2] = 1
    if r_crs_cnt == 5:
        check_arr[3] = 1

    for i in range(5):
        row_cnt = 0
        col_cnt = 0
        for j in range(5):
            if board[i][j] == 0:
                row_cnt += 1
            if board[j][i] == 0:
                col_cnt += 1
        if row_cnt == 5:
            check_arr[0] += 1
        if col_cnt == 5:
            check_arr[1] += 1
    if sum(check_arr) >= 3:
        return True
    return False

board = [list(map(int, input().split())) for i in range(5)]

arr = []
for i in range(5):
    arr += list(map(int,input().split()))
q = deque(arr)

def find():
    cnt = 0 
    while q:
        num = q.popleft()
        cnt += 1
        for y in range(5):
            for x in range(5):
                if board[y][x] == num:
                    board[y][x] = 0
                    break
        if cnt >= 11:
            if check():
                return cnt
    return -1
print(find())
