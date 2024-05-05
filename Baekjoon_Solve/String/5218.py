# 알파벳 거리 (5218번)
import sys
input = sys.stdin.readline

TC = int(input().rstrip())
for _ in range(TC):
    s1, s2 = input().rstrip().split()
    n = len(s1)
    lst = []
    for i in range(n):
        x = ord(s1[i]) - 65
        y = ord(s2[i]) - 65
        if y >= x:
            lst.append(y - x)
        else:
            lst.append(y + 26 - x)

    print(f'Distances: {" ".join(list(map(str, lst)))}')

