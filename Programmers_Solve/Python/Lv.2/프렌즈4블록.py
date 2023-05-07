# 프렌즈4블록
def solution(m, n, board):
    answer = 0
    for i in range(m):
        board[i] = list(board[i])
    block_set = set() # 제거할 블록의 좌표를 담은 집합
    while True:
        removable = check(m, n, board, block_set) # 삭제 가능한 블럭의 개수를 구함
        if removable == 0: # 그러한 블럭의 수가 0이면 break
            break
        answer += removable
        remove_blocks(board, block_set)
        drop_blocks(m, n, board)
        block_set = set() # 집합을 초기화
    return answer


# 2x2블럭이 제거 가능한지 체크하는 함수 -> 집합의 길이를 반환
def check(r: int, c: int, board: list, _set: set) -> int:
    # r - 1, c - 1까지 탐색함. 어차피 2x2블럭을 탐색하니 인덱스 에러 방지 목적
    for y in range(r - 1):
        for x in range(c - 1):
            if board[y][x] != "0": # 빈 공간이 아니고
                right = board[y][x + 1] # 우측
                down = board[y + 1][x] # 하단
                right_down = board[y + 1][x + 1] # 우측 하단
                if board[y][x] == right == down == right_down: # 4곳 모두 같은 문자면 삭제 가능
                    _set.add((y, x))
                    _set.add((y, x + 1))
                    _set.add((y + 1, x))
                    _set.add((y + 1, x + 1))
    return len(_set)


# 블록을 제거하는 함수
def remove_blocks(board: list, _set: set) -> None:
    for y, x in _set:
        board[y][x] = "0"
    return


# 블록을 떨어뜨리는 함수
def drop_blocks(r: int, c: int, board: list) -> None:
    # 아래에서 부터 탐색하여 블럭을 떨어뜨림
    for y in range(r - 2, -1, -1):
        for x in range(c):
            if board[y][x] != "0": # 빈 칸이 아닐 경우
                ny = y
                while ny + 1 < r and board[ny + 1][x] == "0":
                    board[ny][x], board[ny + 1][x] = board[ny + 1][x], board[ny][x] # 스왑
                    ny += 1
    return