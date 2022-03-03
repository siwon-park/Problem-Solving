# 스도쿠(2239번)
########################################################
    # 문제: https://www.acmicpc.net/problem/2239
    # 구현, 백트랙킹
    # 이전에도 풀어본 스도쿠 문제와 유사하지만, 내 코드는 역시 너무 느리다.
    # 풀면서 도중에 실수를 몇가지 하는 바람에 디버깅하는데 시간이 걸렸다.
    # Pypy3로 4732ms로 느리게 통과하는데, 더 빨리 풀 수 있는 방법이 있을 것이다. 심지어 아예 정답을 제일빨리 찾고나면 exit()을 하게 했는데도 시간 개선은 미미했다.
    # 다른 사람 풀이를 보고 더 빨리, 효율적으로 풀 수 있는 방법을 알아봐야겠다.
########################################################
import sys
input = sys.stdin.readline

board = [list(map(int, list(input().rstrip()))) for _ in range(9)]

def check(y, x, num):
    # 행이나 열에 같은 숫자가 발견되면 return False
    for k in range(9):
        if board[y][k] == num:
            return False
        if board[k][x] == num:
            return False
    # 격자에 같은 숫자가 있는지 체크
    grid_y, grid_x = (y//3)*3, (x//3)*3
    for r in range(grid_y, grid_y + 3):
        for c in range(grid_x, grid_x + 3):
            if board[r][c] == num:
                return False
    return True

def solve_sudoku():
    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                for num in range(1, 10):
                    if check(i, j, num):
                        board[i][j] = num
                        solve_sudoku()
                        board[i][j] = 0
                return
    for lst in board:
        print("".join(list(map(str, lst))))
    exit()

solve_sudoku()
