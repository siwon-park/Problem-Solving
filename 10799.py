#쇠막대기(10799번)
###############################
    # 문제: https://www.acmicpc.net/problem/10799
    # 스택
    # "("이면 일단 스택에 넣고, ")"이면 바로 그 전이 무엇이었는지, 또는 stack의 마지막 값이 무엇인지에 따라 처리를 다르게 하였음
    # 일단, ")"이 들어오려고 하는데, 바로 그 전 문자가 "(" 이었다면 레이저인 경우이므로, stack의 마지막 값을 빼고(어차피 마지막이 "("이었으므로, 스택값도 동일)
    # 스택의 길이 만큼 cnt에 +를 해준다.
    # 만약 레이저가 아니라(즉, ")"이 지금 들어오려고 하지만, 바로 그 전 마지막 문자가 "("은 아닌 경우), 
    # stack의 마지막 값이 "("라면, 지금 반복 구문에서 들어오려는 ")"는 어느 한 쇠막대기의 끝을 의미하므로, stack에서 마지막 값을 뺴고, cnt+=1을 해준다.
###############################
import sys
input=sys.stdin.readline
irons=list(input().rstrip())
last=""
stack=[]
cnt=0
for iron in irons:
    if iron=="(":
        stack.append(iron)
    elif iron==")":
        if last=="(":
            stack.pop()
            cnt+=len(stack)
        elif stack[-1]=="(":
            stack.pop()
            cnt+=1    
    last=iron    
print(cnt)      

