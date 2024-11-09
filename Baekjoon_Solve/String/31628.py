# 가지 한 두름 주세요 (31628번)
import sys
input = sys.stdin.readline


def solve():
    flag = False
    arr = []
    for i in range(10):
        lst = input().rstrip().split()
        arr.append(lst)
        last = lst[0]
        for j in range(1, 10):
            if last != lst[j]:
                break
            last = lst[j]
        else:
            flag = True

    if flag:
        return 1

    for j in range(10):
        last = arr[0][j]
        for i in range(1, 10):
            if last != arr[i][j]:
                break
            last = arr[i][j]
        else:
            flag = True

    if flag:
        return 1
    else:
        return 0

print(solve())

