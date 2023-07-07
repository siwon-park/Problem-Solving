# 센서(2212번)
import sys
input = sys.stdin.readline

N = int(input())
K = int(input())
lst = list(map(int, input().split()))
lst.sort()

arr = []
for i in range(1, N):
    arr.append(lst[i] - lst[i - 1])

arr.sort(reverse=True)
ans = sum(arr[K - 1:])

print(ans)
