import sys

input = sys.stdin.readline

# 첫 번째 문제는 정말 쉬운 문제일까? (34071번)
n = int(input().rstrip())
lst = []
for i in range(n):
    lst.append(int(input().rstrip()))

if lst[0] == min(lst):
    print("ez")
elif lst[0] == max(lst):
    print("hard")
else:
    print("?")

