# 행운의 티켓(1639번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/1639
    # 브루트포스
    # i를 시작점, j를 끝점으로 잡고 mid 값을 구해서 s1과 s2를 비교하고 같을 경우 그 때의 길이를 최대 길이로 갱신하는 방법으로 풀면 된다.
    # 왜 이런 종류의 브루트포스를 풀 때마다 이상하게 생각이 많아지고 자꾸 효율적인 풀이를 찾느라 많은 시간을 소비하는지 모르겠다. 일단 푸는 게 더 중요한데...
#####################################################################################
import sys
input = sys.stdin.readline

S = list(map(int, input().rstrip()))
N = len(S)

max_len = 0
for i in range(N):
    for j in range(i + 1, N, 2):
        mid = (j + i) // 2
        s1, s2 = sum(S[i:mid + 1]), sum(S[mid + 1: j + 1])
        if s1 == s2:
            max_len = max(max_len, j - i + 1)

print(max_len)
