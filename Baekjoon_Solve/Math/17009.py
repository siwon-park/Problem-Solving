import sys

input = sys.stdin.readline

# Winning Score (17009번)
lst1 = [int(input().rstrip()) for _ in range(3)]
lst2 = [int(input().rstrip()) for _ in range(3)]

s = 3
s1, s2 = 0, 0
for i in range(3):
    s1 += lst1[i] * s
    s2 += lst2[i] * s
    s -= 1

if s1 > s2:
    print("A")
elif s1 < s2:
    print("B")
else:
    print("T")

