import sys

input = sys.stdin.readline

# 계산기 프로그램 (5613번)
ret = 0
idx = 0
last = "+"
while True:
    line = input().rstrip()
    if line == "=":
        break
    if idx % 2 == 0:
        num = int(line)
        if last == "+":
            ret += num
        elif last == "-":
            ret -= num
        elif last == "*":
            ret *= num
        elif last == "/":
            ret //= num
    else:
        last = line
    idx += 1

print(ret)

