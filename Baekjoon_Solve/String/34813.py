import sys

input = sys.stdin.readline

# 공통교육과정 (34813번)
s = input().rstrip()
if s[0] == "F":
    print("Foundation")
elif s[0] == "C":
    print("Claves")
elif s[0] == "V":
    print("Veritas")
elif s[0] == "E":
    print("Exploration")

