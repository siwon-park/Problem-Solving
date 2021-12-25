#역사(1613번)
######################################
 # 플로이드-워셜 알고리즘 사용
 # Python3 통과(7588ms), 48번 시도(9% 시간초과 -> 59% 시간초과 -> 81% 시간초과 -> 90% 시간초과 -> 해결)
 # 단순 반복 구문을 사용하는 것보다 함수 내에서 반복 구문을 만들어서 해당 함수를 쓰는 것이 속도가 더 빠르다는 것을 알게됨
 # a,b를 입력 받았을 때, a->b에 대해서 -1을, b->a에 대해서는 1을 부여(그외에는 전부 0)
 # 자기 자신으로 가는 경우를 따지지 않게 하기 위해 모든 노드에 대해 graph[i][i]=9 처럼 아예 다른 숫자를 지정해줬으나, 81%(혹은 90%)에서 시간초과 났음
 # floyd함수 안에서 graph[a][b]==0인 경우일 때만 조건문을 검토하게 했으나(if graph[a][b]==0: ~~), 아래 코드처럼 아예 없는 것이 더 빨랐음
######################################
import sys
input=sys.stdin.readline
n,k=map(int,input().split())
graph=[[0]*(n+1) for i in range(n+1)]
def init():
    for i in range(k):
        a,b=map(int,input().split())
        graph[a][b],graph[b][a]=-1,1
def floyd():
    for k in range(1,n+1):
        for a in range(1,n+1):
            for b in range(1,n+1):
                #if graph[a][b]==0:
                if graph[a][k]==-1 and graph[k][b]==-1:
                    graph[a][b],graph[b][a]=-1,1
def result():
    check=[]
    for i in range(int(input())):
        s1,s2=map(int,input().split())
        check.append(graph[s1][s2])
    for ck in check:
        print(ck)
init()
floyd()
result()
