import sys

input = sys.stdin.readline

# Number Maximization (25773번)
num_lst = list(map(int, input().rstrip()))
num_lst.sort(reverse=True)
print(''.join(map(str, num_lst)))

