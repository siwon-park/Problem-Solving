# 과일 탕후루 (30804번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))

if N == 1:
    print(1)
else:
    l, s, e = 2, 0, 1
    kind = [0 for _ in range(10)]
    kind[arr[s]] += 1
    kind[arr[e]] += 1
    fruits = 2
    if kind[arr[s]] == 2:  # 시작 과일의 개수가 2이상이면 종류는 1개
        fruits = 1
    while s < e < N:
        if fruits <= 2:  # 과일의 종류가 2이하면 끝 포인터를 옮김
            l = max(l, e - s + 1)
            e += 1
            if e < N:
                kind[arr[e]] += 1
                if kind[arr[e]] == 1:
                    fruits += 1
        else:
            kind[arr[s]] -= 1
            if kind[arr[s]] == 0:
                fruits -= 1
            s += 1
    print(l)

