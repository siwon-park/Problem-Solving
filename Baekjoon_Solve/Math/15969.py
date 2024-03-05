# 행복 (15969번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
lst.sort()
print(lst[-1] - lst[0])

