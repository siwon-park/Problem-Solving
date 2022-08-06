# 전력망을 둘로 나누기(프로그래머스 위클리 챌린지 9주차)
#######################################################
    # 양방향 간선으로 연결된 노드들로 구성된 트리에서
    # 하나의 간선을 끊었을 때, 두 집단의 노드 수 차이가 가장 작은 값을 반환해야함
    # 빈 graph 선언 후 a,b 노드에 대해 graph[a]=b, graph[b]=a로 서로 연결시켜준 다음
    # 서로 연결된 모든 두 노드에 대해서 탐색 시작
    # 하나의 노드는 상대 노드를 만나지 않도록 BFS 탐색을 실시하고, 반대에 대해서도 똑같이 진행해준다.(BFS탐색을 하면서 만나는 노드의 개수+=1을 해줌)
    # 두번의 BFS탐색 결과 서로 갖고 있는 노드의 수의 차이의 절댓값을 result 배열에 담아 최솟값을 반환하면 된다.
#######################################################
from collections import deque
def solution(n, wires):
    answer=-1
    graph=[[]*(n+1) for i in range(n+1)]
    for wire in wires:
        a,b=wire
        graph[a].append(b)
        graph[b].append(a)
    result=[]
    for wire in wires:
        a,b=wire
        n1,n2=1,1
        s1,s2={a},{b}
        q1,q2=deque([a]),deque([b])
        while q1:
            cur=q1.popleft()
            for i in graph[cur]:
                if i==b:
                    continue
                if i not in s1:
                    q1.append(i)
                    n1+=1
                    s1.add(i)
        while q2:
            cur=q2.popleft()
            for i in graph[cur]:
                if i==a:
                    continue
                if i not in s2:
                    q2.append(i)
                    n2+=1
                    s2.add(i)
        result.append(abs(n1-n2))
    return min(result)

#print(solution(9,[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]))
#print(solution(4,[[1,2],[2,3],[3,4]]))
#print(solution(7,[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]))
