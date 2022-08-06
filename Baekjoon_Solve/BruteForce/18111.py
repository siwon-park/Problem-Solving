# 마인크래프트(18111번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/18111
    # 구현, 브루트포스
    # Python3 시간초과, Pypy3 통과(568ms)
    # 현재 배열의 최솟값과 최댓값 사이의 값으로 평탄화를 진행하면 된다.
    # 평탄화 목표 높이(h)가 평탄화 대상 높이(num)보다 크면 임시 인벤토리(tmp_B)에서 해당 차이만큼 빼준다.(기존 인벤토리에서 블럭을 꺼내 쌓는 개념임)
    # 그리고 1*(h-num)만큼 시간을 더 해준다. 왜냐하면, 인벤토리에서 1개를 옮기는데 1의 시간이 걸리기 때문인데, h-num개 옮겼으므로 그렇다.
    # 반대로 평탄화 대상 높이(num)가 목표 높이(h)보다 클 경우 높이 차이(num-h)만큼 임시 인벤토리에 더 해준다.
    # 그리고 역시 2*(num-h)만큼 시간을 더해준다. 기존 블럭을 인벤토리에 넣는 것은 2초가 걸리는데 num-h개를 인벤토리에 넣었으므로 그렇다.
    # 마지막으로, 현재의 임시 인벤토리가 0이상일 경우, 현재의 시간과 최소 시간을 비교하고, 그 때의 높이도 비교하여 최종적으로 최소 시간과 그 때의 최대 높이를 출력한다.
#######################################################
import sys
sys.stdin.readline

N, M, B = map(int, input().split())
lst = []
for i in range(N):
    lst.extend(list(map(int, input().split())))

min_h, max_h = min(lst), max(lst)
min_t, max_height = int(1e9), -1

for h in range(min_h, max_h+1):
    tmp_B = B
    tmp_t = 0
    for num in lst:
        if num < h:
            tmp_B -= h-num
            tmp_t += 1*(h-num)
        elif num > h:
            tmp_B += num-h
            tmp_t += 2*(num-h)
    # print(tmp_t, h, tmp_B)
    if tmp_B >= 0:
        if tmp_t <= min_t:
            min_t = tmp_t
            if h > max_height:
                max_height = h

print(min_t, max_height)
