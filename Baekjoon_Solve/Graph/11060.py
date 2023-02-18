# 점프 점프(11060번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/11060
    # BFS, 다이나믹 프로그래밍
    # 문제의 태그에 DP가 달려있는데, 솔직히 왜 DP인지 모르겠다.
    # 왜냐하면 BFS로 현재위치에서 다음위치까지 도달할 수 있는 어떤 점까지의 거리는 연결 간선의 가중치가 같고 첫 방문일 경우에 항상 최단거리를 보장하기 때문이다.
    # 이 문제도 사실 가중치는 1이다. 이동할 수 있는 간격만 A[i]로 차이가 있을 뿐이지
    # 굳이 DP가 아니라 그동안에 왔던 거리를 넣어주고 BFS를 돌리면 답이 나온다.
#######################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
dp = [-1] * N
dp[0] = 0
q = deque([(0, 0)]) # 거리, 위치
while q:
    d, cur = q.popleft()
    for i in range(A[cur] + 1):
        if cur + i < N and dp[cur + i] == -1:
            dp[cur + i] = d + 1
            q.append((d + 1, cur + i))
print(dp[N-1])
