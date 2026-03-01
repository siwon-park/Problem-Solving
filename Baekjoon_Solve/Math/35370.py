import sys

input = sys.stdin.readline

# Memories of Passport Control (35370번)
k, s = map(int, input().rstrip().split())
if s < k:
    print(s)
else:
    if s % k == 0:
        print(s // k)
    else:
        print(s - (k - 1) * (s // k))

