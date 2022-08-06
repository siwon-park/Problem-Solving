# 링크와 스타트(15661번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/15661
    # 브루트포스, 백트랙킹
    # 부분집합을 구해서 부분집합의 S[i][j]의 합의 차이가 최소가 되는 것을 찾는 문제이다.
    # Python3는 시간초과, Pypy3는 816ms로 통과
    # 중복 방지를 했는데도 불구하고 시간초과가 나는 걸 봐서는 가지치기를 잘해야 Python3로도 통과할 듯 싶다.
###################################################################
import sys
input = sys.stdin.readline

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]
min_diff = sys.maxsize

def dfs(k, A, B):
    global min_diff
    if k == N:
        if A and B:
            A_total, B_total = 0, 0
            for i in range(len(A)):
                for j in range(i+1, len(A)):
                    A_total += S[A[i]][A[j]] + S[A[j]][A[i]]
            for i in range(len(B)):
                for j in range(i+1, len(B)):
                    B_total += S[B[i]][B[j]] + S[B[j]][B[i]]
            min_diff = min(min_diff, abs(A_total - B_total))
        return
    # k를 A팀에 넣는다
    dfs(k+1, A+[k], B)
    # k를 B팀에 넣는다
    dfs(k+1, A, B+[k])

dfs(1, [0], []) # 중복 방지를 위해 A에 0을 넣고, k=1부터 출발함

print(min_diff)
