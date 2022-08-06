# 키로거(5397번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/5397
    # 스택
    # 정말이지, 문제 구현을 다 해놓고서 거의 마지막에 실수를 하여서 질문게시판에서 반례를 찾고 있었다.
    # else 구문에서 while 구문을 통해서 tmp에 있는 모든 요소에 대해 pop을 하여 ret에 append를 해주고 있었다.
    # tmp의 모든 요소에 대해서는 마지막에 처리를 해줘야하는데 나의 실수였다.
    # 왜냐하면 tmp에서 모든 요소를 뽑아서 ret에 append한다는 것은 커서를 맨 마지막으로 옮긴다는 의미와 같은 것인데
    # else는 그냥 문자열에 대해서 ret에 append하는 과정이지, 커서는 사실 상 움직이면 안 된다. 
    # tmp에 요소가 있더라도 뽑아서 현재의 ret에 append할 필요가 없다.
    # 문제 구상 및 설계를 거의 다 해놓고선 약간의 큰 실수가 있었다.
##############################################################################
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    S = input().rstrip()
    L = len(S)
    ret = [] # 결과를 담을 배열
    tmp = [] # 잠깐 동안 문자열을 담을 배열
    for i in range(L):
        if S[i] == "<": # "<"이면 ret에 요소가 있으면 마지막 요소를 뽑아서 tmp에 넣는다
            if ret:
                tmp.append(ret.pop())
        elif S[i] == ">": # ">"이면 tmp에 요소가 있으면 마지막 요소를 뽑아서 ret에 넣는다
            if tmp:
                ret.append(tmp.pop())
        elif S[i] == "-": # "-"이면 ret에 요소가 있으면 마지막 요소를 제거한다
            if ret:
                ret.pop()
        else: # 문자열이면 ret에 요소를 추가함
            ret.append(S[i])
            ###### 내가 실수 했던 부분 ###### else에서 해당 처리를 해주면 안 된다.
            # while tmp:
            #     ret.append(tmp.pop())
            ################################ 
    while tmp: # 남은 tmp에 대해 처리해준다
        ret.append(tmp.pop())
        
    print("".join(ret))
