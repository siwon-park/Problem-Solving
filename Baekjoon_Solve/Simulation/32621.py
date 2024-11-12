# 동아리비 횡령 (32621번)
import sys
input = sys.stdin.readline


def solve(line: str) -> str:
    if line.count("+") > 1 or len(line) < 3:
        return "No Money"
    cnt = 0
    for w in line:
        if 'a' <= w <= 'z' or 'A' <= w <= 'Z':
            return "No Money"
        if w == '+':
            cnt += 1
    if cnt != 1:
        return "No Money"
    lst = line.split("+")
    if lst[0].startswith("0") or lst[1].startswith("0"):
        return "No Money"
    if int(lst[0]) == int(lst[1]):
        return "CUTE"
    return "No Money"


print(solve(input().rstrip()))

