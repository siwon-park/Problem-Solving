import sys

input = sys.stdin.readline

# ISBN (6810번)
a = int(input().rstrip())
b = int(input().rstrip()) * 3
c = int(input().rstrip())

print(f'The 1-3-sum is {91 + a + b + c}')

