import sys

input = sys.stdin.readline

# Do Not Touch Anything (13136번)
R, C, N = map(int, input().rstrip().split())
r = R // N if R % N == 0 else (R // N) + 1
c = C // N if C % N == 0 else (C // N) + 1

print(r * c)

