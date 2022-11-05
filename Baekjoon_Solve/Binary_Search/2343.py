# 기타 레슨(2343번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/2343
    # 매개변수 탐색
    # 구간 합 중 최댓값이 최소가 되는 경우를 찾는 문제이다.
    # arr[i]가 mid보다 큰 경우 블루레이를 M개 만들 수 없으므로 break를 해줘야한다.
    # 만약 그렇지 않으면, 만들 수 없음에도 cnt가 M개 이하인 경우가 나와 답이 갱신될 가능성이 있다.
#############################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

s = 0
e = sum(arr)
opt = e
while s <= e:
    mid = (s + e) // 2
    cnt = 1
    cur = 0
    for i in range(N):
        if arr[i] > mid:
            cnt = N + 1
            break
        cur += arr[i]
        if cur > mid:
            cnt += 1
            cur = arr[i]
    if cnt <= M:
        opt = min(opt, mid)
        e = mid - 1
    else:
        s = mid + 1

print(opt)
