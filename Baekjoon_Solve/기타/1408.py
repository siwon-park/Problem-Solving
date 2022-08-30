# 24(1408번)
##################################################################################################
    # 문제: https://www.acmicpc.net/problem/1408
    # 수학, 구현
    # 시간에 대한 계산만 잘하면 되는 문제
##################################################################################################
import sys
input = sys.stdin.readline

cur_time = list(map(int, input().split(":")))
start_time = list(map(int, input().split(":")))
left_time = ['', '', '']
for i in range(2, -1, -1):
    if start_time[i] < cur_time[i]:
        if i > 0:
            t = 60 + start_time[i] - cur_time[i]
        else:
            t = 24 + start_time[i] - cur_time[i]
        start_time[i - 1] -= 1
    else:
        t = start_time[i] - cur_time[i]
    if t < 10:
        left_time[i] = "0" + str(t)
    else:
        left_time[i] = str(t)

print(":".join(left_time))
