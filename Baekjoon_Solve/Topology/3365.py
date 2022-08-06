# 최종 순위(3665번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/3665
    # 위상 정렬(정확히는 위상 정렬 문제는 아님)
    # 몇 가지 말장난(?) 때문에 시간을 꽤나 잡아먹었는데,
    # 첫째는 a, b가 주어진다고 해서 a의 순위가 b보다 높게 바뀌었다는 것이 아니라, a와 b의 상대 순위가 바뀌었다는 뜻이었음. b > a일수도, a > b일수도 있다는 의미임
    # 그리고 두 번째는 확실한 순위를 찾을 수 없는 경우에 "?"를 출력하라는 것인데, 사실상 "?"는 존재할 수가 없다.
    # 왜냐하면 확실한 순위를 찾을 수 없다는 의미는 위상 정렬 결과가 여러 개 나온다는 의미인데,
    # 일단 위상 정렬이 다 된 상태이고, 상대 순위가 바뀐 '모든' 팀의 목록이 주어진다고 했으므로, 상대 순위 정보가 부족해서 정답이 여러 개 나오는 경우는 존재할 수 없다.
    # 따라서 그 결과는 정확하게 바뀐 순위를 알거나, 잘못된 데이터로 일관성이 없어서 순위를 정할 수 없는 경우이다.
###############################################################
import sys, heapq
input=sys.stdin.readline
T=int(input())
def topology_sort():
    org_indegree=[0]*(n+1) # 위상 정렬 결과에 대한 원본 진입 차수 배열
    ranks=list(map(int,input().split()))
    rank=n-1
    for r in ranks:
        org_indegree[r]=rank
        rank-=1
    m=int(input())
    if m==0: # m==0이면 현재의 위상 정렬 결과를 반환(n을 넣은 이유는 아래에 상대 순위가 정상적으로 위상 정렬 결과를 출력해서 판별할 때와 맞추기 위해서임)
        return ranks, n
    indegree=org_indegree[:] # 바뀔 진입 차수 배열을 선언(원본 진입 차수 복사)
    for i in range(m):
        a,b=map(int,input().split())
        if org_indegree[a]>org_indegree[b]: # 이 문제의 핵심 포인트, 결국 상대 순위가 바뀌었다라는 것은 현재 위상 정렬된 결과를 기준으로 판단해야하는 것임!
            indegree[a]-=1
            indegree[b]+=1
        else:
            indegree[a]+=1
            indegree[b]-=1
    q=[]
    for i in range(1,n+1):
        heapq.heappush(q,(-indegree[i],i)) # 최대 힙 활용(1등 부터 구하는 것이니깐 진입 차수가 큰 것부터 뽑기 위해서)
    result=[]
    last=n-1 # 최대 힙이므로 진입 차수의 시작은 무조건 n-1부터임
    cnt=0 # 위상 정렬된 요소의 개수
    while q:
        ind,cur=heapq.heappop(q)
        if -ind==last:
            result.append(cur)
            cnt+=1
            last-=1
    return result,cnt # 정렬 결과와 그 개수를 반환
for _ in range(T):
    n=int(input())
    ans=topology_sort()
    if ans[1]==n: # 정렬이 잘 되었다면 모든 요소가 정렬된 것이므로, ans[1](=cnt)의 값이 n과 일치해야한다
        print(*ans[0])
    else:
        print("IMPOSSIBLE")
