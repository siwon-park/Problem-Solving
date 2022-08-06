# 경고(3029번)
#############################################################
    # 문제: https://www.acmicpc.net/problem/3029
    # 문자열, 구현
    # 각 자리수(시간, 분, 초)별 상태에 따라 조건을 달리하여 계산하였음
    # 문제에서 1초이상 기다린다고 했으므로 최종 나온 결과가 "00:00:00"이라면 "24:00:00"을 출력해야한다.
#############################################################
import sys
input = sys.stdin.readline

t1 = list(map(int, input().split(":")))
t2 = list(map(int, input().split(":")))

if t2[2] < t1[2]:
    t2[1] -= 1
    t2[2] = t2[2]+60 - t1[2]
else:
    t2[2] -= t1[2]
if t2[1] < t1[1]:
    t2[0] -= 1
    t2[1] = t2[1]+60 -t1[1]
else:
    t2[1] -= t1[1]
if t2[0] < t1[0]:
    t2[0] = t2[0]+24 - t1[0]
else:
    t2[0] -= t1[0]
t = []
for num in t2:
    if num < 10:
        t.append("0"+str(num))
    else:
        t.append(str(num))

t = ":".join(t)
if t == "00:00:00":
    t = "24:00:00"
print(t)
