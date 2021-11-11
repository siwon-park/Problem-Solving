#뱀과 사다리 게임(16928번)
#####################################################
    # BFS 이용
    # 코드 개선 필요: bfs함수 내에 if구문을 하나 줄여서 4528ms →4224ms로 줄였으나 여전히 느려서 개선 필요
    # 아래 주석과 같이 bfs에서 좀 더 빨리 count값을 반환받기 위해 현재 위치에 따라 반환조건을 설정하였음
    # 개선 결과 4244ms에서 92ms로 대폭 감소, 메모리 사용도 거의 1/10로 줄어듦
    # 개선 포인트는 while 구문에서 visited를 체크할 때 q.popleft() 이후 체크하는 것이 아니라, while 구문 밖에서 초기 visited[1]=True를 설정하고,
    # while 구문 안의 for구문 내에서 q에 요소를 집어 넣을 때, visited[cur+i]=True로 체크해준다.
    # 이렇게 하면 방문 체크 방식이 선(先)체크 방식이 되면서 시간이 대폭 줄고, 자동적으로 큐에 들어가는 요소의 개수도 줄기 때문에 메모리 사용량도 줄게 됨
    # 항상 개선된 방식으로 방문을 체크해서 BFS를 풀곤했는데, 이번에는 별 차이 없겠지 하면서 큐에서 뽑을 때 방문을 체크하게 해봤는데, 차이가 컸다.
#####################################################

##################개선전(4244ms)########################
import sys
from collections import deque
input=sys.stdin.readline
info=[i for i in range(101)]
N,M=map(int,input().split())
for i in range(N):
    x,y=map(int,input().split())
    info[x]=y
for i in range(M):
    u,v=map(int,input().split())
    info[u]=v
def min_count():
    visited=[False]*101
    q=deque([(1,0)])
    while q:
        cur,count=q.popleft()
        visited[cur]=True
        if 94<=cur<=100: # 현재 위치가 94이상 100이하면
            if cur==100:
                return count # 만약 현재 위치가 100이면 count를 반환
            else:
                return count+1 # 만약 현재 위치가 94~99사이면 count+1을 반환(주사위 던져서 갈 수 있으니)
        for i in range(1,7):
            if cur+i>100:
                continue
            if not visited[cur+i]:
                q.append((info[cur+i],count+1))
print(min_count())

################개선후(92ms)###################
import sys
from collections import deque
input=sys.stdin.readline
info=[i for i in range(101)]
N,M=map(int,input().split())
for i in range(N):
    x,y=map(int,input().split())
    info[x]=y
for i in range(M):
    u,v=map(int,input().split())
    info[u]=v
def min_count():
    visited=[False]*101
    q=deque([(1,0)])
    visited[1]=True
    while q:
        cur,count=q.popleft()
        if 94<=cur<=100:
            if cur==100:
                return count
            else:
                return count+1
        for i in range(1,7):
            if cur+i>100:
                continue
            if not visited[cur+i]:
                q.append((info[cur+i],count+1))
                visited[cur+i]=True
print(min_count())
