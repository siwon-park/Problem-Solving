import sys

input = sys.stdin.readline

# Fair Grading (34282번)
x, y, z = map(int, input().rstrip().split())
x *= 0.25
y *= 0.25
z *= 0.5
total = x + y + z

if total >= 90:
    print("A")
elif total >= 80:
    print("B")
elif total >= 70:
    print("C")
elif total >= 60:
    print("D")
else:
    print("F")

