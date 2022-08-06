#A → B(16953번)
################################################
    # 문제: https://www.acmicpc.net/problem/16953
    # BFS
    # 처음에 cur>B이면 -1을 return하게 했으나 이는 틀렸음. 왜냐하면 A가 2이고 B가 8이라고 할 때,
    # 3번의 연산으로 8을 만들 수 있지만, 2 다음에 21을 큐에 삽입하여 2가 8이 되기도 전에
    # 위 조건에 의해 -1을 출력하게 됨.
################################################
import sys
from collections import deque
input=sys.stdin.readline
A,B=map(int,input().split())
q=deque([(1,A)])
def check():
    while q:
        cnt,cur=q.popleft()
        if cur==B:
            return cnt
        if cur*2<=B:       
            q.append((cnt+1,cur*2))
        if int(str(cur)+"1")<=B:
            q.append((cnt+1,int(str(cur)+"1")))
    return -1        
print(check())
