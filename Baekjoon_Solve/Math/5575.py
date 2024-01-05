# 타임 카드 (5575번)
import sys
input = sys.stdin.readline

lst_A = list(map(int, input().rstrip().split()))
lst_B = list(map(int, input().rstrip().split()))
lst_C = list(map(int, input().rstrip().split()))


def cal_time(lst: list):
    hh1 = lst[0]
    mm1 = lst[1]
    ss1 = lst[2]
    hh2 = lst[3]
    mm2 = lst[4]
    ss2 = lst[5]

    hh = 0
    mm = 0
    ss = 0

    if ss1 > ss2:
        ss = ss2 + 60 - ss1
        mm2 -= 1

    else:
        ss = ss2 - ss1

    if mm2 < 0:
        mm2 += 60
        hh2 -= 1

    if mm1 > mm2:
        mm = mm2 + 60 - mm1
        hh2 -= 1
    else:
        mm = mm2 - mm1

    hh = hh2 - hh1
    return hh, mm, ss


print(*cal_time(lst_A))
print(*cal_time(lst_B))
print(*cal_time(lst_C))
