# 좌석 배치도 (30889번)
import sys
input = sys.stdin.readline

arr = [["." for _ in range(20)] for _ in range(10)]

N = int(input().rstrip())
for _ in range(N):
    reserve = input().rstrip()
    row = ord(reserve[0]) - 65
    col = int(reserve[1:]) - 1
    arr[row][col] = 'o'

for lst in arr:
    print("".join(lst))
