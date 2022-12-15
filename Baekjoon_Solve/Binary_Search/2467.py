# 용액 (2467번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/2467
    # 이분탐색, 투 포인터
    # 이분탐색으로 풀어보았다. (투 포인터 풀이 아래 추가)
    # lowerbound를 구현하여 현재 수의 반대 부호를 가진 수를 배열에 넣을 위치를 찾는다.
    # 찾은 인덱스를 가지고, indx - 1, indx, indx + 1이 i가 아니면서, 0이상 N미만의 수이면
    # 현재 수와 더한 값의 절댓값을 최솟값의 절댓값과 비교한다.
    # 절댓값을 하는 이유는 0과 가까운 수를 찾아야 하므로
    # 0에서 어떤 수를 뺀 값의 절대값이 작으면 작을 수록 0과 가깝다는 점을 이용하는 것이다.
########################################################################################
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))


def lower_bound(arr, L, value):
    idx = 0
    s, e = 0, L
    while s <= e:
        mid = (s + e) // 2
        if value <= arr[mid]:
            e = mid - 1
        else:
            s = mid + 1
            idx = mid
    return idx


M = len(lst)
ret = []
total = 2 * int(1e9)
for i in range(M):
    v = lst[i]
    if v <= 0:
        indx = lower_bound(lst, M - 1, abs(v))
    else:
        indx = lower_bound(lst, M - 1, -v)
    if indx - 1 >= 0 and indx - 1 != i and abs(v + lst[indx - 1]) < abs(total):
        total = v + lst[indx - 1]
        ret = [v, lst[indx - 1]]
    if indx + 1 < M and indx + 1 != i and abs(v + lst[indx + 1]) < abs(total):
        total = v + lst[indx + 1]
        ret = [v, lst[indx + 1]]
    if indx != i and abs(v + lst[indx]) < abs(total):
        total = v + lst[indx]
        ret = [v, lst[indx]]

ret.sort()
print(*ret)

#########################################################################
    # 투 포인터 풀이
#########################################################################
N = int(input())
arr = list(map(int, input().split()))
arr.sort()

L = 0
R = len(arr) - 1
_min = 0xffffffff
result_L, result_R = arr[L], arr[R]

while L < R:
    _sum = arr[L] + arr[R]

    if abs(_min) > abs(_sum):
        result_L, result_R = arr[L], arr[R]
        _min = _sum

    if _sum > 0:
        R -= 1
    elif _sum < 0:
        L += 1
    else:
        break

print(result_L, result_R)
