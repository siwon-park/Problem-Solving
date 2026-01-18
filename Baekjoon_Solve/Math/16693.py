import sys, math

input = sys.stdin.readline

# Pizza Deal (16693번)
a, p1 = map(int, input().rstrip().split())
r1, p2 = map(int, input().rstrip().split())

ration1 = a / p1
ration2 = r1 ** 2 * math.pi / p2

if ration1 > ration2:
    print("Slice of pizza")
elif ration1 < ration2:
    print("Whole pizza")

