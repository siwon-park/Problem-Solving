import sys

input = sys.stdin.readline

# 99 Problems (25270번)
list_99 = [99]
for i in range(100, 100001, 100):
    list_99.append(i + 99)

N = int(input().strip())
idx = 0
for i in range(len(list_99)):
    if N <= list_99[i]:
        idx = i
        break

if idx == 0:
    print(99)
else:
    if abs(N - list_99[idx]) <= abs(N - list_99[idx - 1]):
        print(list_99[idx])
    else:
        print(list_99[idx - 1])

