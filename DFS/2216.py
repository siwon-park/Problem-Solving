# 숫자판 점프(2210번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/2210
    # DFS(깊이 우선 탐색), 브루트포스
    # 처음에 그래도 가급적 중복을 피할 수 있는 방법이 없을까 고민했다.
    # 예를 들면 (0, 0) 탐색 후 (0, 1)로 가는 루트와 (0, 1)에서 (0, 0)으로 가면 중복이지 않나 싶었는데,
    # 생각해보니 두 좌표에 위치한 숫자가 다르면 서로 다른 조합이 만들어지고, 두 좌표의 숫자가 같더라도 그 이후에 숫자가 한개라도 다르면
    # 다른 조합이 만들어진다. 따라서 브루트포스로 완전탐색을 DFS로 해야하는 문제였다.
    # 처음 시도는 108m/s가 나왔는데, 다른 사람 풀이를 잠깐 보다가 내가 실수한 부분이 있다는 것을 깨달았다.
    # 2중 for문에서 각 좌표별로 dfs함수를 처음 호출하기 시작할 때 dfs(i, j, 0, "") 이렇게 호출했다.
    # (i, j)에서 출발하니까 숫자도 board[i][j]로 시작해야하고 길이(k)도 1부터 출발했어야 했는데 작은 실수였다. 고치고 나니 72m/s로 시간이 줄었다.
#####################################################
import sys
input = sys.stdin.readline

board = [input().rstrip().split() for _ in range(5)]

s = set()
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

# y, x는 좌표, k는 숫자의 길이, num은 만들어지는 숫자(문자열)
def dfs(y:int, x:int, k:int, num:str) -> None:
    if k == 6:
        s.add(num)
        return
    for dy, dx in dydx:
        ny, nx = y+dy, x+dx
        if 0 <= ny < 5 and 0 <= nx < 5:
            dfs(ny, nx, k+1, num+board[ny][nx])
    return

for i in range(5):
    for j in range(5):
        dfs(i, j, 1, board[i][j])

print(len(s))
