# 공통 부분 문자열(5582번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/5582
    # DP
    # 정말로 바보같이 답을 다 구해놓고서는 왜 답이 안 나오지 고민하다가
    # 잘못된 풀이로 계속 시도하고 있었다.
    # 문자열이 서로 일치할 경우에만 DP 배열 갱신 및 최고 길이 갱신 작업을 해주면 된다.
    # 처음에는 짰을 때는 추가적으로 일치하지 않을 경우에, max(3개 주변 값)을 해주었는데
    # 답이 안 나와서 해당 부분을 지우고 전체 dp배열을 출력했는데, 예제 최댓값이 dp배열에 있었음에도 불구하고 없는 줄 알고
    # 다른 방법을 계속 시도하다가 다시 보니까 내가 잘못봤던 것이었다. 시간만 30분 날렸다...
######################################################################
import sys
input = sys.stdin.readline

s1 = input().rstrip()
s2 = input().rstrip()

n1, n2 = len(s1), len(s2)

dp = [[0 for j in range(n2 + 1)] for i in range(n1 + 1)]

max_len = 0
for i in range(1, n1 + 1):
    for j in range(1, n2 + 1):
        if s1[i-1] == s2[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
            max_len = max(max_len, dp[i][j])

print(max_len)

########## 메모이제이션 풀이 ##########
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(r, c):
    if not r*c:
        return memo[r][c]
    if s1[r-1] == s2[c-1]:
        memo[r][c] = memo[r-1][c-1] + 1
    return memo[r][c]

s1 = input().rstrip()
s2 = input().rstrip()

n1, n2 = len(s1), len(s2)

memo = [[0 for j in range(n2 + 1)] for i in range(n1 + 1)]

max_len = 0
for i in range(1, n1 + 1):
    for j in range(1, n2 + 1):
        max_len = max(max_len, dfs(i, j))

print(max_len)
