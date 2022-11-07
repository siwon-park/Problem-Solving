# 안녕 클레오파트라 세상에서 제일가는 포테이토칩(25904번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/25904
    # 구현
    # 아래 있는 매우 간단한 풀이처럼 모듈러 연산(%)를 이용해서 풀 수 있을 것이라 생각은 했는데, 구현은 하지 못했다.
    # 그래서 그냥 큐를 활용하여 풀었다. 어차피 문제에서 주어진 값이 작고, 생각해보니 어차피 조건을 만족할 때까지 순환해야했기 때문이다.
###################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, X = map(int, input().split())
T = list(map(int, input().split()))

q = deque()
for i in range(N):
    q.append((T[i], i + 1))

while q:
    vc, idx = q.popleft()
    if X > vc:
        print(idx)
        break
    else:
        X += 1
        q.append((vc, idx))

#####################################################################################
# 매우 간단한 풀이
N, X = map(int, input().split())
T = list(map(int, input().split()))
i = 0
while T[i % N] >= i + X:
    i += 1
print(i % N + 1)
