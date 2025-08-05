import sys

input = sys.stdin.readline

# 지우개 (21756번)
N = int(input().rstrip())
lst = [i for i in range(1, N + 1)]
while len(lst) > 1:
    temp = []
    for i in range(1, len(lst), 2):
        temp.append(lst[i])
    lst = temp[:]

print(lst[0])

