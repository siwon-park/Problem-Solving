#저울(10159번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/10159
    # 플로이드-워셜 알고리즘 사용, Python3 160ms통과
    # 1613번 역사 문제와 거의 동일한 문제
    # 초기 그래프의 모든 값은 0으로 설정하고, a,b 두 물체의 무게를 비교해서 a > b이면 graph[a][b]=1을, graph[b][a]=-1로 설정한다.
    # 1이든 -1이든 무게를 비교할 수 있다는 의미이다.
    # 자기자신에 대해서는 -1, 0, 1이 아닌 아무 숫자로 설정한다.
    # graph[a][k]==1 이고, graph[k][b]==1이면 graph[a][b]==1, graph[b][a]==-1로 설정한다.('a > k 이고 k > b 이므로 a > b 다'라고 말할 수 있기 때문이다.)
    # 이후 i번째 물건이 j번째 물건과 비교할 수 없으면(graph[i][j]==0), count+=1을 하여 N번째까지 전부 확인 후 출력하는 것을 반복한다
#######################################################
import sys
input=sys.stdin.readline
N=int(input())
M=int(input())
graph=[[0]*(N+1) for i in range(N+1)]
def init():
    for i in range(M):
        a,b=map(int,input().split())
        graph[a][b]=1
        graph[b][a]=-1
    for i in range(1,N+1):
        graph[i][i]=9
def floyd():
    for k in range(1,N+1):
        for a in range(1,N+1):
            for b in range(1,N+1):
                if graph[a][k]==1 and graph[k][b]==1:
                    graph[a][b]=1
                    graph[b][a]=-1
def result():
    for a in range(1,N+1):
        count=0
        for b in range(1,N+1):
            if graph[a][b]==0:
                count+=1
        print(count)
init()
floyd()
result()
