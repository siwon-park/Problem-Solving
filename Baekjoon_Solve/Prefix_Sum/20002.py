# 사과나무(20002번)
##################################################################################################
    # 문제: https://www.acmicpc.net/problem/20002
    # 누적합, 브루트포스
    # 그냥 브루트포스로 풀면 O(300X300X300X300)이므로 시간초과가 날 것이 분명하다
    # 따라서 누적합 배열을 구한 뒤에 KxK배열만큼의 구간 누적합을 구해 최댓값을 구하면 된다.
    # Python3로는 시간초과가 나서 Pypy3로 풀었고 476ms로 통과할 수 있었다.
    # java로도 풀어보았다.(처음에 java로 풀려다가 왠지 시간을 너무 많이 잡아먹을 것 같아서 파이썬으로 풀고 java로 옮겨보았다)
##################################################################################################
import sys
input = sys.stdin.readline

INF = sys.maxsize
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
prefix_sum = [[0 for _ in range(N + 1)] for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        prefix_sum[i][j] = prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1] + board[i - 1][j - 1]

def find_range_sum(r2, c2):
    max_range_sum = -INF

    for k in range(1, N + 1):
        r1, c1 = r2 - k, c2 - k
        if 0 <= r1 < N and 0 <= c1 < N:
            range_sum = prefix_sum[r2][c2] - prefix_sum[r2][c1] - prefix_sum[r1][c2] + prefix_sum[r1][c1]
            max_range_sum = max(max_range_sum, range_sum)

    return max_range_sum

ans = -INF
for r in range(1, N + 1):
    for c in range(1, N + 1):
        temp_ans = find_range_sum(r, c)
        ans = max(ans, temp_ans)

print(ans)
