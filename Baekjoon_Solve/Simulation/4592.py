# 중복을 없애자 (4592번)
import sys
input = sys.stdin.readline

while True:
    inp = input().rstrip()
    if inp[0] == "0":
        break
    stack = []
    lst = list(map(int, inp.split()[1:]))
    for n in lst:
        if not stack:
            stack.append(n)
        else:
            if n == stack[-1]:
                continue
            else:
                stack.append(n)
    stack.append("$")

    print(" ".join(map(str, stack)))


