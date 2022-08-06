# 후위 표기식(1918번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/1918
    # 스택
    # 중위 표기식을 받았을 때, 후위 표기식으로 만드는 문제이다.
    # 후위 표기식을 만들때 스택을 활용하면 되는데, 2개의 스택이 필요하다. 1개는 결과를 담을 스택, 다른 1개는 잠깐 동안 연산자를 쌓아두는 스택이다.
    # 1) 연산자가 아니면 무조건 결과 스택에 넣는다.
    # 2) 연산자일 경우 연산자 스택에 넣되, 스택의 마지막 요소의 우선순위와 지금 들어오려는 연산자의 우선순위를 따져서 행동을 달리한다.
    # 스택에서 마지막 요소를 뽑을 때는 항상 스택에 요소가 있는지부터 체크해야한다.
    # 3) 들어오려는 연산자가 ')'일 경우에는 '('이 나올 때까지('(' 포함) 연산자 스택에서 다 뽑아서 결과 스택에 담는다.
    # 4) 들어오려는 연산자가 ')'이 아닐 경우에는 연산자 스택의 마지막에 있는 연산자 우선순위가 현재 들어오려는 연산자의 우선순위보다 높거나 같은 동안에
    # 연산자 스택에서 pop하여 결과 스택에 넣는다. 단, 여기서 연산자 스택의 마지막 요소가 '('일 때는 들어오려는 연산자를 넣는다.
    # 사실 스택 안에서의 연산자 우선 순위와 스택 밖의 연산자 우선 순위가 다르기 때문에
    # 정석적으로 풀려면 스택 밖의 연산자 우선 순위와 스택 안의 연산자 우선 순위를 구분해줘야한다.
    # 5) 3번 4번 케이스가 아닐 경우, 연산자 스택에 넣는다.
    # 마지막으로 연산자 스택에 연산자가 남아있으면, 전부 다 뽑아서 결과 스택에 넣는다.
    # 참고) 정석: '('은 스택 밖에서는 우선순위가 가장 높지만, 스택 안에 있다면 우선순위가 가장 낮다.
##################################################################
import sys
input = sys.stdin.readline

strings = input().rstrip()
out_stack = []
in_stack = []
operater = {'+':1, '-':1, '*':2, '/':2, '(':3, ')':3}

for s in strings:
    if s in operater:
        if s == ')':
            while out_stack and out_stack[-1] != '(':
                in_stack.append(out_stack.pop())
            out_stack.pop()
        elif out_stack:
            while out_stack and out_stack[-1] != '(' and operater[out_stack[-1]] >= operater[s]:
                in_stack.append(out_stack.pop())
            out_stack.append(s)
        else:
            out_stack.append(s)
    else:
        in_stack.append(s)
while out_stack:
    in_stack.append(out_stack.pop())

print(''.join(in_stack))
