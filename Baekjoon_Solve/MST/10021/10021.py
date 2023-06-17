# Watering the Fields(10021번)
########################################################
    # 문제: https://www.acmicpc.net/problem/10021
    # 최소 스패닝 트리(MST)
    # 이 문제는 다익스트라로도 풀 수 있음(다익스트라 풀이에 올려둠)
    
    # 크기가 2000001인 edges배열을 선언하고 두 좌표의 거리에 해당하는 인덱스에 두 좌표를 리스트 또는 튜플화하여 넣고 해당 배열을 활용해서
    # 크루스칼 알고리즘으로도 풀이가 가능함
    
    # 2달전에 이 문제를 풀면서 계속 메모리 초과가 나서 포기했는데, 결국 도움을 받아서 프림 알고리즘으로 해결했고,
    # 다른 사람의 풀이를 참조해보니, 내가 제출했었던 일반적인 크루스칼로도 통과가 가능하다.
    # 그런데 이상한 것은 내가 그동안 메모리 초과났던 코드와 통과한 크루스칼 알고리즘 풀이의 차이가
    # 단지 최소 스패닝 트리로 연결하는 부분을 함수로 묶어줬냐 안 줬냐의 차이였다.(나는 함수화하였음)
    # 똑같은 풀이라면 경험상 BOJ에서 함수 호출을 통해서 푸는게 더 빨랐고, 도중에 return으로 호출을 종료해줘도 되니 여러모로 이점이 있어서
    # 함수화시켰는데, 메모리 초과가 났던 것이다. 그런데 더 중요한 것은 시간을 투자해서 찾아봐도 왜 메모리 초과가 나는지 분명하게 모르겠다.
    # 그전에는 edges배열에 최대 200만이 넘는 수가 최악의 경우 2000*1999크기의 배열에 들어가게 되므로
    # 100만이 넘는 배열에 100만이 넘는 숫자를 저장해서 그렇게 되었나보다 싶었는데,
    # 막상 똑같이 edges를 만들고 돌렸을 때, 시간초과 나는 코드도 있는거 봐서는 단순히 자료형으로 인한 메모리 초과는 아닌듯하다.
    # 내 기억이 맞다면 9%에서 메모리초과나 시간초과였으니 적어도 여기서 시간초과가 났다는 것은 메모리 초과가 발생하지 않았다는 뜻 아닌가?
    # 다음에 백준 게시판에 질문을 올려서 답을 얻을 수 있으면 업데이트하겠음
########################################################

######################## 일반적인 크루스칼 알고리즘(4684ms) #################################
import sys
from itertools import combinations
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a, b = find_parent(parent, a), find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, C = map(int, input().split())
lst = []
for i in range(N):
    x, y = map(int, input().split())
    lst.append((i+1, x, y))

edges = []
for comb in combinations(lst, 2): # 2중 for 구문으로도 구현이 가능하지만, 메모리 사용 최소화 실험으로 itertools의 combinations 사용
    d = (comb[0][1] - comb[1][1])**2 + (comb[0][2] - comb[1][2])**2
    if d >= C:
        edges.append((d, comb[0][0], comb[1][0]))
edges.sort()

parent = [i for i in range(N+1)]
result = 0
cnt = 0

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
        cnt += 1
        if cnt == N-1: # edges를 전부 다 탐색하게 된다면 시간초과 판정을 받으므로 최소 스패닝 트리가 완성되는 순간 break함
            print(result)
            break
else:
    print(-1)
