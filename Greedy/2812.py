# 크게 만들기(2812번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/2812
    # 문제를 다 풀어놓고서는 뭐가 잘못됐는지 못찾아서 1시간을 헤맸다.
    # 978보다 981이 더 큰데도 불구하고, 자꾸 잘못된 답이라고 생각해서 이상하게 헤맸다.
    # 들어오려는 숫자가 stack의 맨 마지막 요소보다 크면 스택의 마지막 요소가 현재 들어오려는 숫자보다 크거나 같을 때까지
    # 스택에서 빼면서 뺀 횟수를 증가시킨다. 단, 빼는 횟수가 K를 초과하지 않도록 한다
    # 그리고 최종적으로 나와야하는 숫자는 N-K자리 숫자이므로, stack을 N-K까지 자른다음 출력하면 된다.
################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
num = list(map(int, list(input().rstrip())))

stack = [num[0]]
i = 1
k = K
while i < N:
    cur = num[i]
    while stack and stack[-1] < cur and k:
        last = stack.pop()
        k -= 1
    stack.append(cur)
    i += 1
stack = stack[:N-K] # 최종적으로 나와야하는 숫자는 N-K자리 숫자이므로, stack을 N-K까지 자른다
print("".join(list(map(str, stack))))
