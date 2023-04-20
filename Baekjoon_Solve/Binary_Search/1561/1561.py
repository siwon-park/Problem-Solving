import math
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split()) # 아이들의 수, 놀이 기구의 수
arr = list(map(int, input().rstrip().split())) # 놀이 기구의 운영 시간


def binary_search():
    s = 0
    e = min(arr) * N # N명의 아이들이 탈 수 있는 최소 시간
    t = e # N명의 아이들이 모두 탈 수 있는 최소 시간
    while s <= e:
        mid = (s + e) // 2 # N명의 아이들이 놀이 기구를 타는데 걸리는 시간
        cnt = 0
        for i in range(M): # N명이 아이들이 놀이 기구를 타는데 걸리는 시간을 운영 시간으로 나눈 값의 올림을 누적함
            cnt += math.ceil(mid / arr[i])
        if cnt >= N: # mid 시간으로 운영했을 때, N명 이상이 탈 수 있다면 시간을 줄임
            e = mid - 1
            t = mid
        else:
            s = mid + 1

    cnt = 0 # t - 1시간까지의 탄 아이들의 수
    for i in range(M):
        cnt += math.ceil((t - 1) / arr[i])

    for i in range(M):
        if (t - 1) % arr[i] == 0: # t - 1시간으로 나누어 떨어지면 t시간으로는 나누어 떨어지지 않으므로 탈 수 있음
            cnt += 1
            if cnt == N:
                return i + 1


print(binary_search())