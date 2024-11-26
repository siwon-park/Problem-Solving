# PlayStation이 아니에요 (32132번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
S = input().rstrip()
stack = []
for i in range(N):
    w = S[i]
    if len(stack) < 2:
        stack.append(w)
    else:
        if stack[-2] == "P" and stack[-1] == "S":
            if w == "4" or w == "5":
                continue
            stack.append(w)
        else:
            stack.append(w)

print("".join(stack))

