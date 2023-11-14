# 감마선을 맞은 컴퓨터 (30402번)
import sys
input = sys.stdin.readline

ans = ""
for i in range(15):
    line = input().rstrip().split()
    for j in range(15):
        if line[j] == "w":
            ans = "chunbae"
        elif line[j] == "b":
            ans = "nabi"
        elif line[j] == "g":
            ans = "yeongcheol"

print(ans)
