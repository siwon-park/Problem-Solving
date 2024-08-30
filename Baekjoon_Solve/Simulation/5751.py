# Head or Tail (5751번)
import sys
input = sys.stdin.readline

while True:
    N = int(input().rstrip())
    if N == 0:
        break
    lst = list(map(int, input().rstrip().split()))
    m = 0
    j = 0
    for num in lst:
        if num == 0:
            m += 1
        else:
            j += 1
    print(f'Mary won {m} times and John won {j} times')

