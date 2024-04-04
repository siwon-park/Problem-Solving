# 가위 바위 보? (4493번)
import sys
input = sys.stdin.readline

tc = int(input().rstrip())
for _ in range(tc):
    p1, p2 = 0, 0
    n = int(input().rstrip())
    for i in range(n):
        rsp1, rsp2 = map(str, input().rstrip().split())
        if rsp1 == "R" and rsp2 == "S":
            p1 += 1
        elif rsp1 == "R" and rsp2 == "P":
            p2 += 1
        elif rsp1 == "S" and rsp2 == "P":
            p1 += 1
        elif rsp1 == "S" and rsp2 == "R":
            p2 += 1
        elif rsp1 == "P" and rsp2 == "R":
            p1 += 1
        elif rsp1 == "P" and rsp2 == "S":
            p2 += 1
    if p1 == p2:
        print("TIE")
    elif p1 > p2:
        print("Player 1")
    else:
        print("Player 2")

