# Words (4072번)
import sys
input = sys.stdin.readline

while True:
    line = input().rstrip()
    if line == "#":
        break
    lst = line.split()
    for word in lst:
        print(word[::-1], end=" ")
    print()

