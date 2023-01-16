# 롤케이크 (16206번)
"""
  문제: https://www.acmicpc.net/problem/16206
  그리디, 정렬
  롤 케이크를 정렬한 다음, 10으로 나누어지는 경우를 우선적으로 고려한 다음 10으로 나누어 떨어지지 않는 경우를 계산하면 된다.
  같은 횟수를 자를 수 있다고 했을 때, 10으로 나누어 떨어지는 경우가 그렇지 않은 경우보다 길이가 10인 롤 케이크를 더 많이 얻을 수 있기 때문이다.
  롤 케이크 정렬에 대한 아이디어를 떠오르기 힘들 수도 있는데, 주어진 예제 4번을 보면 오름차순 정렬을 해줘야하는 것을 캐치할 수 있다.
"""
import sys
input = sys.stdin.readline

cnt = 0
N, M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()
m = 0 # 자른 횟수

# 10으로 나누어 떨어지는 케이크부터 우선 자름
for i in range(N):
    if not lst[i] % 10:
        if lst[i] == 10:
            cnt += 1
        else:
            n = lst[i] // 10
            if m + n - 1 <= M:
                cnt += n
                m += n - 1
            else:
                cnt += M - m
                m = M

# 10으로 나누어 떨어지지 않는 경우
if m < M:
    for i in range(N):
        if lst[i] % 10 and lst[i] > 10:
            n = lst[i] // 10
            if m + n <= M:
                cnt += n
                m += n
            else:
                cnt += M - m
                m = M

print(cnt)
