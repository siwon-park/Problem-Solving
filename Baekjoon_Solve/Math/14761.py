import sys

input = sys.stdin.readline

# FizzBuzz (14761번)
x, y, n = map(int, input().rstrip().split())
for i in range(1, n + 1):
    if i % x == 0 and i % y == 0:
        print("FizzBuzz")
    elif i % x == 0:
        print("Fizz")
    elif i % y == 0:
        print("Buzz")
    else:
        print(i)

