# 빗물(14719번)
############################################################
    # 문제: https://www.acmicpc.net/problem/14719
    # 구현, 시뮬레이션, 스택, 큐
    # 처음에 어떻게 풀어야 하나 고민을 하다가 스택이나 큐를 활용하면 될 것 같다는 느낌만 들었다.
    # 그래서 수도코드를 작성해보면서 논리를 생각하다가 이렇게 해보자 해서 짰고 통과했다.
    # 로직은 이렇다. 일단 처음에 입력으로 들어오는 모든 칸의 높이는 큐에 담는다.
    # 0번 인덱스의 높이를 큐에서 popleft하고 초기 기준점으로 삼는다. 그리고 큐에서 popleft한 요소들을 잠깐 담을 배열인 water를 선언한다.
    # while q인 동안에 큐에서 요소를 빼면서(=cur) 기준점과 비교를 한다. 만약 기준점이 더 크다면 water에 cur를 담고,
    # 그게 아니라 기준점보다 크거나 같으면, water에 있는 요소를 전부 비우면서 기준점에서 water의 요소를 뺀 값을 빗물의 총량을 담을 변수인 rain에 누적한다.
    # cur가 기준점보다 크거나 같으므로 둘 중 작은 값은 당연히 기준점이 된다. 따라서 기준점에서 water의 요소값들을 빼주는 것이다. 그래야 빗물이 넘치지 않고 정확하게 쌓인다.
    # 그리고 last는 cur로 갱신시켜주고, water에 last값을 담는다.(q가 비고 나서 사용하기 위함임)
    # 그후, water에 남아있는 요소에 대해서 거의 비슷한 로직으로 돌려준다.
    # 이렇게 하는 이유는 만약 중간에 나온 cur값이 제일 큰 높이의 값이여서 배열의 끝까지 갔을 때 쌓여야 하는 빗물의 총량을 계산하기 위함이다.
    # 먼저 처음과 다르게 이번에는 last를 water의 마지막 인덱스 값으로 선언한다. 왜냐면 끝에서 부터 역순으로 확인하기 위해서이다.
    # 처음에 큐(+스택)의 개념을 썼다면, 이번에는 스택의 개념만 사용한다.
    # 그외에 스택 안에서 돌아가는 로직은 처음에 적용했던 로직과 같다.
############################################################
import sys
from collections import deque
input = sys.stdin.readline

H, W = map(int, input().split())
q = deque(list(map(int, input().split())))
rain = 0
last = q.popleft()
water = []
# 순차
while q:
    cur = q.popleft()
    if last > cur:
        water.append(cur)
    elif last <= cur:
        while water:
            rain += last-water.pop()
        last = cur
        water.append(last)
# 역순
last = water.pop()
w = []
while water:
    cur = water.pop()
    if last > cur:
        w.append(cur)
    elif last <= cur:
        while w:
            rain += last - w.pop()
        last = cur

print(rain)
