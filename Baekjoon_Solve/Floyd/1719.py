#택배(1719번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/1719
    # 플로이드-워셜 알고리즘
    # 최단 거리를 구하는 문제가 아니라, 최단 경로에서 출발점 바로 다음의 노드 번호를 출력해야하는 문제
    # 노드의 수(n)이 200이하여서 플로이드 워셜 알고리즘을 사용해도 충분히 통과할 수 있다고 생각하였음
    # 최단 경로를 구하기 위해 경유지를 기록하는 0을 초기값으로 가지는 2차원의 path배열과 find_path함수를 만드는 것이 포인트
#####################################################
import sys
input=sys.stdin.readline
INF=sys.maxsize
n,m=map(int,input().split())
graph=[[INF]*(n+1) for i in range(n+1)]
path=[[0]*(n+1) for i in range(n+1)] # 경유지를 기록하기 위한 2차원의 배열 path 선언 
for i in range(1,n+1):
    graph[i][i]=0
for i in range(m):
    a,b,c=map(int,input().split())
    graph[a][b]=c # 양방향 입력임
    graph[b][a]=c

def floyd():
    for k in range(1,n+1):
        for a in range(1,n+1):
            for b in range(1,n+1):
                new_cost=graph[a][k]+graph[k][b]
                if new_cost<graph[a][b]:
                    graph[a][b]=new_cost
                    path[a][b]=k # 최단 거리를 갱신할 때, a->b로 갈 때 k를 경유해서 갔다는 의미로 path배열에 기록
floyd()

# 최단 경로를 구하는 find_path 함수 선언
# 현재 함수대로 한다면 최단 경로의 경유지만 구하는 것이므로 완벽한 최단 경로는 [s]+find_path(s,e)+[e]임
def find_path(s,e):
    if path[s][e]==0: # path[s][e]==0이라는 의미는 s에서 e로 갈 때, 경유하지 않고 바로 갔다는(갈 수 있다는) 의미임
        return []
    w=path[s][e]
    return find_path(s,w)+[w]+find_path(w,e)

for i in range(1,n+1):
    for j in range(1,n+1):
        if i==j:
            print("-", end=" ")
        else:
            lst=find_path(i,j)
            if not lst: # 빈 리스트를 반환받았다면 path[i][j]==0, 즉 i에서 j로 바로 갈 수 있다는 의미이므로 출발지 바로 다음은 j이므로 j를 출력해야함
                print(j, end=" ")
            else:
                print(lst[0],end=" ")    
    print()            
