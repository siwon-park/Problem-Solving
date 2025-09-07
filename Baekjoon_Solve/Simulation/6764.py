import sys

input = sys.stdin.readline

# Sounds fishy! (6764번)
lst = [int(input().rstrip()) for _ in range(4)]

if lst[0] < lst[1] < lst[2] < lst[3]:
    print("Fish Rising")
elif lst[0] > lst[1] > lst[2] > lst[3]:
    print("Fish Diving")
elif lst[0] == lst[1] == lst[2] == lst[3]:
    print("Fish At Constant Depth")
else:
    print("No Fish")

