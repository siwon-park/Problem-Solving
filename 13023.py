#ABCDE(13023번)
##########################################
    # DFS 이용(문제 모음에 큐와 그래프라고 되어있어서 BFS로 풀었다가 틀렸음)
    # DFS를 어떻게 구현하느냐가 포인트
    # dfs함수 내의 첫줄에 visited[cur]=True로 체크하고 맨 마지막 줄에 다시 visited[cur]=False로 돌려놓는데,
    # 이렇게 하지 않고 dfs내의 for구문에서 visited배열을 하나 복사해서 진행할 경우 7%에서 시간초과가 난다.(N의 최댓값이 2000이라서 그렇다)
    # 첫줄에 visited 체크를 하고 for구문을 다 빠져나온 뒤 마지막에 다시 체크를 풀어줌으로써 visited배열의 복사 없이
    # 어떤 분기점에서 한 노드를 방문 후, 다른 한 노드를 방문 가능하다
    # 아래 입력 예시를 보면
    # 5 5
    # 0 1
    # 1 3
    # 1 2
    # 2 3
    # 3 4
    # 1→3이 1→2보다 먼저오기 때문에, graph[1]=[0,3,2]로 되어있고 0부터 출발한다 했을 때, 해당 순으로 dfs를 방문하게 되면 0→1→3→2→4인데 문제에서 원하는 친구 관계는 못 만듦
    # 근데 만약에 이제 dfs 마지막 줄에 visited[cur]=False를 넣으면 0→1→3→2→4→2→3→4이고 이 때 관계 수를 괄호로 표시해서 넣으면0(0)→1(1)→3(2)→2(3)→4(3)→2(2)→3(3)→4(4)가 됨
    # 즉, 이 말은 0→1→3→2→4로 갔다가 관계 수 3이 된 뒤, 2를 4보다 먼저 방문했으니 2부터 초기화 → 4초기화 → 3초기화까지 한 뒤, 3다음 수인 2를 방문해서 가게 됨
##########################################
import sys
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[[] for i in range(N)]
for i in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
result=[]

def dfs(cur,rel,visited):
    visited[cur]=True
    #print(cur,end=" ")
    if rel>=4:
        result.append(rel)
        return
    for nxt in graph[cur]:
        if not visited[nxt]:
            dfs(nxt,rel+1,visited)
    visited[cur]=False # 이 부분을 반드시 써줘야 함

def check():
    for i in range(N):
        visited=[False]*N
        dfs(i,0,visited)
        #print()
        if result:
            return 1
    return 0
print(check())
