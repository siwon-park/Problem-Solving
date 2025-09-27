import sys

input = sys.stdin.readline

# 찾아오시는 길 (34217번)
A, B = map(int, input().rstrip().split())
C, D = map(int, input().rstrip().split())

total1, total2 = A + C, B + D
if total1 < total2:
    print("Hanyang Univ.")
elif total1 > total2:
    print("Yongdap")
else:
    print("Either")

