# 지뢰찾기(4396번)
################################################################
    # 문제: https://www.acmicpc.net/problem/4396
    # 구현
    # 풀면서 인덱싱 오류가 나서 한 5분 디버깅했는데, 원인은 o_board[y][x] = str(cnt)로 하지 않고, o_board = str(cnt)로 해서 
    # o_board를 문자열로 바꾸는 실수를 범했음
################################################################
import sys
input = sys.stdin.readline

n = int(input())
dydx = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]

# 지뢰가 있는 칸
m_lst = []
m_board = []
for i in range(n):
    lst = list(input().rstrip())
    m_board.append(lst)
    for j in range(n):
        if lst[j] == "*":
            m_lst.append((i, j))

# 열린칸 기준으로 탐색
flag = False # 열린 칸이 지뢰였으면 True로 전환
o_board = []
for y in range(n):
    o_board.append(list(input().rstrip()))
    for x in range(n):
        if o_board[y][x] == "x":
            cnt = 0
            for dy, dx in dydx:
                ny, nx = y+dy, x+dx
                if 0 <= ny < n and 0 <= nx < n:
                    if m_board[ny][nx] == "*":
                        cnt += 1
            o_board[y][x] = str(cnt)
            if m_board[y][x] == "*":
                flag = True
                
# flag == True면 지뢰를 전부 기록
if flag:
    for y, x in m_lst:
        o_board[y][x] = "*"

for lst in o_board:
    print("".join(lst))
