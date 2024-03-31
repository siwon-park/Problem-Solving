# 배수와 약수 (5086번)
import sys
input = sys.stdin.readline

while True:
    first, second = map(int, input().rstrip().split())
    if first == 0 and second == 0:
        break
    if second % first == 0:
        print("factor")
    elif first % second == 0:
        print("multiple")
    else:
        print("neither")

