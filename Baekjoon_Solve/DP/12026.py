# BOJ거리(12026번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/12026
    # DP
    # 메모이제이션으로 풀어보았다.
    # 어려운 문제가 아니었는데, 약간 코드에 실수가 있었고, 헤메는 바람에 시간이 조금 걸렸다.
    # 특히, 가장 많이 시간이 걸렸던 곳은 다 구했는데, 값이 의도했던 대로 누적이 되지 않는 것이었다.
    # 곰곰히 코드를 보면서 생각해보니 val을 갱신하는 줄에서 계산을 같이 해줘야 했었는데,
    # 그냥 val만 갱신하고 있어서 그랬었다.
#####################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

# N이 'B'면, 'J'를 밟아야 함, 'O'면 'B'를 밟아야 함, 'J'면 'O'를 밟아야 함
N = int(input())
road = ["J"] + list(input().rstrip())

INF = int(1e9)
memo = [INF] * (N + 1)
memo[1] = 0

def dfs(n):
    if n == 1:
        return memo[n]
    if memo[n] != INF:
        return memo[n]
    val = INF
    if road[n] == "B":
        for i in range(1, n):
            if road[i] == "J":
                val = min(val, dfs(i) + (n - i) ** 2)
    elif road[n] == "O":
        for i in range(1, n):
            if road[i] == "B":
                val = min(val, dfs(i) + (n - i) ** 2)
    elif road[n] == "J":
        for i in range(1, n):
            if road[i] == "O":
                val = min(val, dfs(i) + (n - i) ** 2)

    memo[n] = min(val, memo[n])
    return memo[n]

dfs(N)

if memo[N] == INF:
    print(-1)
else:
    print(memo[N])
