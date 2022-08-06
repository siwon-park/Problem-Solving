#소수 경로(1963번)
#################################################
    # 문제: https://www.acmicpc.net/problem/1963
    # BFS(너비 우선 탐색), 에라토스테네스의 체(소수 판정)
    # 에라토스테네스의 체를 이용하여 1부터 10000까지의 소수를 체크함
    # 각 테스트 케이스 마다 visited 배열은 초기화, A와 B는 리스트 형태로 입력을 받음(인덱스별 숫자 교환을 하기 위함)
#################################################
import sys
from collections import deque
input=sys.stdin.readline
check=[True]*10001
check[0],check[1]=False,False
for i in range(2,10001):
    if check[i]:
        j=2
        while i*j<=10000:
            check[i*j]=False
            j+=1

T=int(input())
for _ in range(T):
    A,B=list(map(list,input().split())) # A와 B는 리스트 형태로 입력 받음
    visited=[False]*10001
    q=deque([(0,A)])
    visited[int("".join(A))]=True
    flag=False
    while q:
        cnt,cur=q.popleft()
        if cur==B:
            print(cnt)
            flag=True
            break
        for i in range(4):
            for j in range(10):
                if i==0 and j==0: # i와 j 둘 다 0이면 0017과 같은 네 자리수가 아닌 소수도 고려하게되므로 예외 처리
                    continue
                nxt=cur[:]
                nxt[i]=str(j)
                num=int("".join(nxt))
                if check[num] and not visited[num]:
                    q.append((cnt+1,nxt))
                    visited[num]=True
    if not flag:
        print("Impossible")
