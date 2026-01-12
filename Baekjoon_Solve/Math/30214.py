import sys

input = sys.stdin.readline

# An Easy-Peasy Problem (30214번)
s1, s2 = map(int, input().rstrip().split())
if s1 * 2 >= s2:
    print("E")
else:
    print("H")

