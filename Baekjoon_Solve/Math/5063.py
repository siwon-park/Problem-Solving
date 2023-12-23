# TGN (5063번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for _ in range(N):
    r, e, c = map(int, input().rstrip().split())
    if e - c == r:
        print("does not matter")
    elif e - c > r:
        print("advertise")
    else:
        print("do not advertise")
