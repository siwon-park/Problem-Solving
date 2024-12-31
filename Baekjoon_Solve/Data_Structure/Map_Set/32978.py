# 아 맞다 마늘 (32978번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
set1 = set(map(str, input().rstrip().split()))
set2 = set(map(str, input().rstrip().split()))

print(set1.difference(set2).pop())

