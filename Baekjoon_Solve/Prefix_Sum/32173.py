# 새치기 (32173번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = [0] + list(map(int, input().rstrip().split()))
s = arr[1]  # 만족도 최댓값

prefix_sum = [0 for i in range(N + 1)]
for i in range(1, N + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i]

for i in range(2, N + 1):
    if arr[i] - prefix_sum[i - 1] > s:
        s = arr[i] - prefix_sum[i - 1]

print(s)

