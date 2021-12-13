# 도서관(1461번)
###################################################
    # 문제: https://www.acmicpc.net/problem/1461
    # 그리디 알고리즘
    # 일단 정렬을 실시함
    # 최소 걸음으로 가려면 맨 마지막 책들을 가져다 줄 때 무조건 편도로 가야하고 그 거리가 최대여야함
    # 해당 거리는 정렬 했을 때의 양 끝의 절댓값을 비교하면 되는데, 이 때 중요한 것은 출발을 0에서 했다가 다시 0으로 돌아와야 하므로
    # M개의 책을 들고 제자리에 돌려주다가 책의 좌표 부호가 바뀌는 순간이 오게 되는데, 그 때 M개를 다 갖다 놓는다고 생각하면 안 됨
    # 즉, 음수 영역은 음수 영역끼리만 가져다 주고, 양수 영역은 양수 영역끼리만 가져다 줘야 최소거리가 나옴
    # 처음 편도로 가는 최대 거리를 구하고, 매번 위와 같은 개념을 염두해두고 양 끝의 절댓값 중 큰 값의 x2만큼 이동한다고 보면 됨
###################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
lst=list(map(int,input().split()))
lst.sort()
q=deque(lst)
def greedy():
    if abs(q[0])<abs(q[-1]):
        n=1
        num=q.pop()
        while n<M:
            if q:
                cur=q.pop()
                if num*cur<0:
                    q.append(cur)
                    break
                n+=1
            else:
                break   
        min_work=abs(num)      
    else:
        n=1
        num=q.popleft()
        while n<M:
            if q:
                cur=q.popleft()
                if num*cur<0:
                    q.appendleft(cur)
                    break
                n+=1
            else:
                break
        min_work=abs(num)
    return min_work
mw=greedy()
while q:
    mw+=2*greedy()
print(mw)   
