# 럭비 클럽 (2083번)
import sys
input = sys.stdin.readline

while True:
    line = input().rstrip().split()
    if line[0] == "#" and line[1] == "0" and line[2] == "0":
        break
    ret = "Junior"
    if int(line[1]) > 17 or int(line[2]) >= 80:
        ret = "Senior"
    print(line[0], ret)
