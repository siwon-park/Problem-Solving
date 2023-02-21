# 반도체 설계 (2352번)
########################################################################
    # 문제: https://www.acmicpc.net/problem/2352
    # 이분탐색
    # 이 문제가 왜 이분탐색일까 고민을 하다가 곰곰이 보니까, 결국 가장 긴 증가하는 부분 수열의 길이를 찾는 문제였다.
    # DP로만 가장 긴 증가하는 부분 수열의 길이를 구하는 방법을 알고 있어서 북마크 해두고 이분탐색으로 풀어보았다.
    # 개념은 이분탐색을 통해 배열에 숫자가 들어가야할 위치를 찾는 것이다.
    # 빈 배열을 선언하고 배열의 마지막 값보다 현재 숫자가 크면 뒤에 그냥 넣고
    # 배열의 숫자가 더 크거나 같으면 넣어야 하는 인덱스 값을 찾아서 해당 위치에 있는 숫자를 현재 숫자로 바꾼다.
    # bisect로도 풀 수 있지만, 결국 이분탐색을 통해 어떻게 구현하느냐가 더 중요한 것 같아서 직접 구현해서 풀어보았다.
########################################################################
import sys
input = sys.stdin.readline

n = int(input().rstrip())
p = list(map(int, input().rstrip().split()))


# lower_bound
def lower_bound(array, start, end, target):
    idx = n
    while start <= end:
        mid = (start + end) // 2
        if target <= array[mid]:
            end = mid - 1
            idx = mid
        else:
            start = mid + 1
    return idx


l = 0  # 가장 긴 증가하는 부분 수열의 길이
result = []
for t in p:
    if not result or result[-1] < t:
        result.append(t)
        l += 1
    elif result[-1] >= t:
        i = lower_bound(result, 0, len(result) - 1, t)
        result[i] = t

print(l)
