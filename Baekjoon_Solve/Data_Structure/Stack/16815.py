import sys

input = sys.stdin.readline

# Star in Parentheses (16815번)
S = input().rstrip()
m = len(S)
stack = []
last = ""
for i in range(m):
    if not stack:
        stack.append(S[i])
    else:
        if stack[-1] == "(" and S[i] == ")":
            stack.pop()
        else:
            stack.append(S[i])

new_stack = []
n = len(stack)
ans = 0
for i in range(n):
    if stack[i] == "*":
        continue
    if not new_stack:
        new_stack.append(stack[i])
    else:
        if new_stack[-1] == "(" and stack[i] == ")":
            new_stack.pop()
            ans += 1
        else:
            new_stack.append(stack[i])

print(ans)

