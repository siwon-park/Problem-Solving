# 왕복 (18311번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/18311
    # 구현
    # N이 최대 10만, 구간의 최대 길이가 5만이므로 왕복 길이는 최대 5 * 10^4 * 10^5 * 2 = 100억이다.
    # 누적합 배열을 구하면 터질 것이기 때문에
    # K가 편도 길이 초과인지 이하인지를 판별하여 반복문을 돌려서 구간을 출력하였다.
    # 이 때, 이동 거리가 K가 두 코스 사이에 위치한 경우에는 ‘지나야 할’ 코스의 번호를 출력해야하므로
    # 사실상 매번 구간 - 1만큼 누적을 해 준 다음, K이상이면 구간을 출력하고, 아니라면 구간을 이동하고, 출발 지점도 += 1을 해준다.
#########################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))

total = sum(arr)
if K > total:
    start = total
    r = N
    for i in range(N - 1, -1, -1):
        start += arr[i] - 1
        if start >= K:
            print(r)
            break
        r -= 1
        start += 1
else:
    start = 0
    r = 1
    for i in range(N):
        start += arr[i] - 1
        if start >= K:
            print(r)
            break
        r += 1
        start += 1
