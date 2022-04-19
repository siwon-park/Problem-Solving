# 풍선 터뜨리기(2346번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/2346
    # 큐(원형큐)
    # 문제를 잘 읽고 그리면서 구상까지 했는데, 의도했던대로 코드가 동작을 안 하길래 곰곰히 생각해보니 실수가 하나 있었다.
    # 해당 실수 때문에 인덱스 에러가 났었는데, 생각해보니 논리적으로 당연했다.(아래 코드 참조)
############################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
q = deque()
for i, m in enumerate(arr):
    q.append((i+1, m))
balloons = []

while q:
    no, cur = q.popleft()
    if q: # 큐가 비면 더 이상 오른쪽, 왼쪽으로 큐를 돌리거나 할 필요가 없음
        if cur > 0:
            for _ in range(cur - 1):
                q.append(q.popleft())
        elif cur < 0:
            for _ in range(abs(cur)):
                q.appendleft(q.pop())
    balloons.append(no)

print(*balloons)
