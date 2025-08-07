import sys

input = sys.stdin.readline

# exam (18411번)
lst = list(map(int, input().rstrip().split()))
lst.sort()
print(lst[1] + lst[2])

