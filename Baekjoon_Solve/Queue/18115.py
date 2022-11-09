# 카드 놓기 (18115번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/18115
    # 큐, 덱
    # 문제에서 주어진 조건대로 했더니 1, 2, ..., N으로 카드가 쌓였다는 의미이므로
    # 가장 최근에 놓은 카드는 차례대로 1, 2, 3, ...  순이다.
    # 따라서 명령을 거꾸로 하여 1, 2, 3, ... , N 순으로 각 기술에 대해서 처리를 해주면 된다.
##########################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

oq = deque()
q = deque(list(range(1, N + 1)))

for i in range(N - 1, -1, -1):
    num = q.popleft()
    if A[i] == 3:
        oq.append(num)
    elif A[i] == 2:
        tmp = oq.popleft()
        oq.appendleft(num)
        oq.appendleft(tmp)
    else:
        oq.appendleft(num)

print(*oq)
