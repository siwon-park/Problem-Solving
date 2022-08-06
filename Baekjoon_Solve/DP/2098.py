# 외판원 순회(2098번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/2098
    # 비트마스킹, 다이나믹 프로그래밍
    # 외원판 순회에서 출발지는 모든 노드에서 가능하므로 사실상 s는 0에서 출발한다.
    # 비트 체킹을 통해 다 도착하고 나면 s -> 0으로 가는 값을 더해준다.
    # 메모를 통해서 이전에 도착한 적이 있으면 해당 값을 반환하고 탐색을 종료한다.
    # 개인적으로 체감상 많이 어려운 문제였다. 분명히 맞는 것 같은데 안 풀려서 질문게시판도 참고했고 덕분에 몇가지 배운점도 있었다.
    # 1) 메모에 무엇인가 기록할 때, 초기값이 있어야한다. 여기서는 cost = INF이다.
    # 2) 메모 배열을 INF로 초기화하지 않고 0으로 초기화하는 것이 더 빠르다. 이건 설계 및 구현에 따라 갈리는데, 못 도착할 경우 INF를 return 하는데,
    # 못 도착하는 분기가 매우 많으면 INF끼리 비교할 필요가 없는데도 비교를 하여 시간 안에 못 돌아오기 때문이다.
    # 여러 가지로 배울 점이 많이 있는 문제인 것 같다.
###########################################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

INF = int(1e9)
memo = [[0] * (1 << N) for _ in range(N)]

def dfs(k, s):
    if memo[s][k]:
        return memo[s][k]

    if not (k ^ (2**N - 1)): # 모든 도시 방문
        if board[s][0]:
            return board[s][0]
        return INF

    cost = INF
    for i in range(1, N):
        if k & (1 << i):
            continue
        if not board[s][i]:
            continue
        d = dfs(k | (1 << i), i)
        cost = min(cost, d + board[s][i])
    memo[s][k] = cost
    return memo[s][k]

print(dfs(1, 0))
