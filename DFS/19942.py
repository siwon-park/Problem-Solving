# 다이어트(19942번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/19942
    # 백트랙킹, 브루트포스
    # 조건에 맞는 조합을 구하는 백트랙킹 문제. 조건에 부합하면 호출을 중단하고 return하면 된다.
    # 풀고나서 보니 가지치기를 하지 않았는데, price값을 이용해서 가지치기를 한다면 더 빨리 풀 수 있을 것이다.
    # 그런데 3 <= N <= 15이기 때문에 엄청 큰 차이는 없을 듯하다
#########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
min_req = list(map(int, input().split())) # 최소 요구 조건
board = [list(map(int, input().split())) for _ in range(N)] # 표(단백질, 지방, 탄수화물, 비타민, 가격)

ret = [] # 결과를 담을 배열

# 조합 백트랙킹 구성
def dfs(s, comb, price, tmp_ret):
    if comb[0] >= min_req[0] and comb[1] >= min_req[1] and comb[2] >= min_req[2] and comb[3] >= min_req[3]:
        ret.append((price, tmp_ret[:]))
        return
    for i in range(s, N):
        for j in range(4):
            comb[j] += board[i][j]
        price += board[i][4]
        tmp_ret.append(i + 1)
        dfs(i+1, comb, price, tmp_ret)
        tmp_ret.pop()
        price -= board[i][4]
        for j in range(4):
            comb[j] -= board[i][j]

dfs(0, [0, 0, 0, 0], 0, [])

if ret:
    ret.sort()
    print(ret[0][0])
    print(*ret[0][1])
else:
    print(-1)
