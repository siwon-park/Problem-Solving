# 탑(2493번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/2493
    # 스택
    # 처음에 스택의 마지막 값과 해당 값의 위치, 그리고 last라는 변수를 두어 마지막으로 빠져나간 값과 위치를 고려해야하지 않나 생각하고 접근했으나
    # 코드를 짜면서 while구문을 적는 순간 그럴 필요가 없다는 것을 알아차리고, 막힘없이 그대로 짜서 풀 수 있었다.
    # 자세한 풀이는 코드 참조
#########################################################################################
import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

ret = []
stack = []
for i in range(N):
    cur_pos, cur = i+1, arr[i] # 탑의 위치, 탑의 높이
    if not stack: # 스택에 요소가 없으면 삽입
        stack.append((cur_pos, cur))
        ret.append(0) # 0을 추가
    else:
        while stack and cur > stack[-1][1]: # 현재 들어가려는 요소가 스택의 마지막보다 큰 동안
            stack.pop() # 스택의 마지막 요소를 pop()
        if not stack: # 스택이 비어있다면 최고 높이이므로 스택에 삽입하고 결과에 0을 추가
            stack.append((cur_pos, cur))
            ret.append(0)
        else: # 스택에 요소가 들어있다면 스택의 마지막의 위치를 결과에 추가하고 스택에 현재 요소를 삽입
            ret.append(stack[-1][0])
            stack.append((cur_pos, cur))
print(*ret)
