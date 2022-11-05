# 맥주 축제(17503번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/17503
    # 이분 탐색
    # 문제 푸는데 조금 헤맸다.
    # 만족도가 높고, 레벨이 낮은 순으로 정렬해서 cnt가 N이면 break를 하고 범위를 바꿔서 이분 탐색하는 방식으로 처음에 구현했는데
    # 17%에서 자꾸 틀렸습니다를 받았다.
    # 레벨이 낮은 맥주를 마실 수 있는데도 이를 무시하고 이분 탐색을 진행하기 때문이다.
    # 따라서 일단 무조건 배열에 넣고 상위 N개의 합에 대해서 조건을 만족하면 레벨을 줄여서 이분탐색을 진행하고, 그렇지 않으면 레벨을 높이는 방식을 적용했다.
    # 빠른 풀이법을 보니까 우선순위 큐로 풀고 있었다.
    # 앞으로 웬만해서는 먼저 유형을 보지 않고 들어가는 연습을 다시 해야겠다...
#########################################################################
import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
beers = [tuple(map(int, input().split())) for _ in range(K)]
beers.sort(key=lambda x: (-x[0], x[1]))


def binary_search(lst):
    s, e = 1, 2 ** 31
    opt = -1
    while s <= e:
        mid = (s + e) // 2
        drunk = []
        D = 0
        cnt = 0
        for i in range(K):
            if lst[i][1] <= mid:
                cnt += 1
                D += lst[i][0]
                drunk.append(lst[i][0])
        if cnt < N or D < M: # 개수가 N개 미만, 만족도 합이 M 미만이면 레벨을 올림
            s = mid + 1
        else:
            m = 0
            for i in range(N):
                m += drunk[i]
            if m >= M: # 상위 N개의 만족도 합이 M 이상이면
                e = mid - 1
                opt = mid
            else:
                s = mid + 1
    return opt

print(binary_search(beers))

###################################################################################
# 우선 순위 큐 풀이
import sys, heapq
input = sys.stdin.readline

array = []
# N은 기간, M은 선호도의 합, K는 종류
N, M, K = map(int, input().split())
for i in range(K):
    # 선호도, 도수 순서대로 저장
    priority, alcohol = map(int, input().split())
    array.append((priority, alcohol))
array.sort(key = lambda x : (x[1], x[0]))

heap = []
priority_sum = 0
alcohol_sum = 0
for i in range(K):
    priority_sum += array[i][0]
    heapq.heappush(heap, array[i][0])
    if len(heap) == N:
        if priority_sum >= M:
            print(array[i][1])
            break
        else:
            priority_sum -= heapq.heappop(heap)
else:
    print(-1)
