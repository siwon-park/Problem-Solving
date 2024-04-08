# 생일 (5635번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = []
for _ in range(N):
    name, dd, mm, yy = input().rstrip().split()
    lst.append((int(yy), int(mm), int(dd), name))

lst.sort(key=lambda x: (-x[0], -x[1], -x[2]))  # 연도가 높은 순, 월이 높은 순, 일이 높은 순 정렬
print(lst[0][3])
print(lst[N - 1][3])

