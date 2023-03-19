# 좋은 단어(3986번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/3986
    # 스택
    # 같은 단어별로 아치를 그리되 아치가 겹치지 않으려면 스택 자료구조 나타내야 한다.
    # 스택에 단어를 넣고 pop, append연산을 다 끝냈을 때, 최종적으로 스택에 단어가 남아있으면 좋은 단어이다.
#######################################################################
import sys
input = sys.stdin.readline

N = int(input())
ans = 0
for _ in range(N):
    stack = []
    s = input().rstrip()
    for i in range(len(s)):
        if stack and stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])
    if not stack:
        ans += 1

print(ans)
