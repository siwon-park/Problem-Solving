import sys

input = sys.stdin.readline

# 28927번
t1, e1, f1 = map(int, input().rstrip().split())
t2, e2, f2 = map(int, input().rstrip().split())
total1 = t1 * 3 + e1 * 20 + f1 * 120
total2 = t2 * 3 + e2 * 20 + f2 * 120

if total1 > total2:
    print("Max")
elif total1 < total2:
    print("Mel")
else:
    print("Draw")

