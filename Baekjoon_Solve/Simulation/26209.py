import sys

input = sys.stdin.readline

# Intercepting Information (26209번)
lst = list(map(int, input().rstrip().split()))
flag = True
for i in range(len(lst)):
    if lst[i] != 0 and lst[i] != 1:
        flag = False
        break

if flag:
    print("S")
else:
    print("F")

