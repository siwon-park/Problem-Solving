# 짝수를 찾아라 (3058번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    arr = list(map(int, input().rstrip().split()))
    min_even = 102
    even_sum = 0
    for i in range(7):
        if arr[i] % 2 == 0:
            even_sum += arr[i]
            min_even = min(min_even, arr[i])

    print(even_sum, min_even)
