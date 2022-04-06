# 숨바꼭질 2(12851번)
#####################################################################
    # 문제: https://www.acmicpc.net/problem/12851
    # BFS
    # K까지 도달할 수 있는 최소 이동 거리와 그 경우의 수를 출력하는 문제
    # 딕셔너리를 활용했으며, num의 범위는 K가 0<= K <= 10만이므로, 2배까지 범위를 확대해서 정하였다.
    # 처음엔 -20만 ~ 20만으로 범위를 정하였지만 생각해보니 N도 0 <= N <= 10만이므로, -1를 가는 것 자체가 의미가 없다.
    # 3000ms대에서 1500ms대로 개선은 하였지만 분명 여기서도 충분히 줄일 만한 낭비 요소는 존재할 것이다.
    # 예를 들면 N > K이면 +1과 *2는 고려할 필요가 없다. 작아지는 방법은 -1밖에 없기 때문이다.
#####################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
num_dict = dict()
def bfs():
    q = deque([(0, N)])
    num_dict[N] = 0
    ans = 0
    while q:
        cnt, cur = q.popleft()
        if cur == K:
            ans += 1
        nums = [cur - 1, cur + 1, cur * 2]
        for num in nums:
            if 0 <= num <= 200000:
                if num not in num_dict:
                    num_dict[num] = cnt + 1
                    q.append((cnt + 1, num))
                else:
                    if num_dict[num] >= cnt + 1:
                        num_dict[num] = cnt + 1
                        q.append((cnt + 1, num))
    return ans
ret = bfs()
print(num_dict[K])
print(ret)
