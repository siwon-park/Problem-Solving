# 우유 도시(14722번)
#####################################################################
    # 문제: https://www.acmicpc.net/problem/14722
    # 다이나믹 프로그래밍
    # 오랜 숙원 문제 중 하나였던 문제를 드디어 풀었다(약 2개월 전에 첫 시도를 했었고, 여러 번 시도했지만 풀 수 없을 것 같아서 포기했었다.)
    # 메모이제이션에 대해서 조금 익숙해지고 나니까 문제를 어떻게 풀어야할 지 조금씩 보이기 시작했다.
    # 우유는 0 -> 1 -> 2 -> 0 순으로만 마셔야한다. 따라서 메모이제이션을 적용하려면 이것의 역순인 0 <- 2 <- 1 <- 0순으로 돌아와야한다.
    # 단순히 위쪽, 좌측의 우유 종류에 따라서 마신 우유를 증가시키면 안 된다.
    # 에를 들어 출발 지점이 2인데 그 다음 지점이 0이라고 해서 마신 우유가 2가 되진 않는다. 이때 마신 우유는 0이다.
    # 따라서 이를 해결하기위해 가장 마지막에 마신 우유의 종류를 기록하는 last배열을 만들었다.
    # 그리고 조건 분기에 따라 메모이제이션을 해주면서 last배열도 갱신하였다.
    # 만약 0 -> 1 -> 0순으로 만약 지나왔다면 last배열에는 0 -> 1 -> 1로, 가장 마지막에 먹은 우유 종류를 기록하였다.
    # 딸기우유(0)에 대해서만 추가적인 전처리가 있어야 한다는 것을 유의해야한다. 왜냐하면 0이 하나도 안 나오다가 도중에 먹을 수도 있기 때문이다.
    # 그리고 이렇게 코드를 짜고나서도 통과를 할 수가 없었는데, 그 이유는 if, if else구문 때문이었다.
    # 마지막 else구문안에 있던 if 구문을 밖으로 빼서 if, if, if, if 구문을 만드니 통과할 수 있었다.
    # else구문을 쓰면 안 됐던 이유가 if 구문을 돌고나면 갱신 또는 그대로인 상태인데, if -> if -> else가 되면
    # 첫번째 if 구문을 통해 최댓값을 갱신했음에도 불구하고, 두번째 if 구문 조건을 만족하지 않았다면 else구문이 실행되어
    # else구문안에서 첫번째 if 구문에서 갱신했던 최댓값을 다른 값으로 갱신해버리는 문제가 발생하고 있었기 때문이다.
    # 개인적으로는 어려웠던 문제였지만, 이런 문제를 좀 더 풀고 싶다. 연습도 되고 생각도 하면서 좋은 것 같다.
#####################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(r, c):
    if r == 0 and c == 0:
        return memo[0][0]
    if memo[r][c] != -1:
        return memo[r][c]
    left, up = 0, 0
    if c > 0:
        left = dfs(r, c-1)
    if r > 0:
        up = dfs(r-1, c)

    if board[r][c] == 0: # 만약 현재 지점의 우유가 딸기 우유(0)라면
        memo[r][c] = 1  # 메모에 1을 기록한다(어차피 곧 갱신될 수도 있고, 0이 없다가 중간에 0이 나와서 먹기 시작하는 것을 고려하기 위함임)
        last[r][c] = 0 # 현재 방금 먹은 우유가 0이라고 가정하고 일단 0을 기록해준다.
        if r-1 >= 0 and last[r-1][c] == 2: # 마지막 먹은 우유가 바나나 우유(2)일 경우
            if memo[r][c] < up + 1:
                memo[r][c] = up + 1
                last[r][c] = 0
        if c-1 >= 0 and last[r][c-1] == 2:
            if memo[r][c] < left + 1:
                memo[r][c] = left + 1
                last[r][c] = 0
        # 마지막 먹은 우유가 다른 우유일 경우
        if r-1 >= 0 and memo[r][c] < up:
            memo[r][c] = up
            last[r][c] = last[r-1][c]
        if c-1 >= 0 and memo[r][c] < left:
            memo[r][c] = left
            last[r][c] = last[r][c-1]
    elif board[r][c] == 2:
        if r-1 >= 0 and last[r-1][c] == 1:
            if memo[r][c] < up + 1:
                memo[r][c] = up + 1
                last[r][c] = 2
        if c-1 >= 0 and last[r][c-1] == 1:
            if memo[r][c] < left + 1:
                memo[r][c] = left + 1
                last[r][c] = 2
        if r-1 >= 0 and memo[r][c] < up:
            memo[r][c] = up
            last[r][c] = last[r-1][c]
        if c-1 >= 0 and memo[r][c] < left:
            memo[r][c] = left
            last[r][c] = last[r][c-1]
    elif board[r][c] == 1:
        if r-1 >= 0 and last[r-1][c] == 0:
            if memo[r][c] < up + 1:
                memo[r][c] = up + 1
                last[r][c] = 1
        if c-1 >= 0 and last[r][c-1] == 0:
            if memo[r][c] < left + 1:
                memo[r][c] = left + 1
                last[r][c] = 1
        if r-1 >= 0 and memo[r][c] < up:
            memo[r][c] = up
            last[r][c] = last[r-1][c]
        if c-1 >= 0 and memo[r][c] < left:
            memo[r][c] = left
            last[r][c] = last[r][c-1]
    return memo[r][c]

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
memo = [[-1]*N for _ in range(N)]
memo[0][0] = 1 if board[0][0] == 0 else 0
last = [[-1]*N for _ in range(N)]
last[0][0] = board[0][0] if board[0][0] == 0 else -1
print(dfs(N-1, N-1))
