# 공백 없는 A+B (15873번)
import sys
input = sys.stdin.readline

AB = input().rstrip()
if len(AB) == 2:
    print(int(AB[0]) + int(AB[1]))
else:
    if AB[1] == '0':
        A = 10
    else:
        A = int(AB[0])
    if AB[-1] == '0':
        B = 10
    else:
        B = int(AB[-1])
    print(A + B)
