# 수 정렬하기 4 (11931번)
import sys
input = sys.stdin.readline

lst = [int(input().rstrip()) for _ in range(int(input().rstrip()))]
lst.sort(reverse=True)
for n in lst:
    print(n)

