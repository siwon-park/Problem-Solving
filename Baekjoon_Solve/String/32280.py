# 지각생 (32880번)
import sys
input = sys.stdin.readline


def str_to_int(time: str) -> int:
    tmp = time.split(":")
    return int(tmp[0]) * 60 + int(tmp[1])


N = int(input().rstrip())
teacher_arrival = 0
lst = []
for i in range(N + 1):
    info = input().rstrip().split()
    if "teacher" == info[1]:
        teacher_arrival = str_to_int(info[0])
    else:
        lst.append(str_to_int(info[0]))

deadline_arrival = str_to_int(input().rstrip())

ans = 0
for t in lst:
    if t >= deadline_arrival and t >= teacher_arrival:
        ans += 1

print(ans)

