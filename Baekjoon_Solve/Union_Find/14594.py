# 동방 프로젝트(small) (14594번)
####################################################################################################
    # 문제: https://www.acmicpc.net/problem/14594
    # 분리 집합
    # 동방 프로젝트(large)와 같은 문제
    # 실수로 print 출력구문의 들여쓰기가 if문 안에 있어서 100%에서 자꾸 틀렸습니다 판정을 받았다
    # large에서 분명히 풀었는데, 내가 어떻게 비효율성을 제거하면서 풀었는지 기억이 안 나서 내 풀이를 참조했다...
    # 사실 뭐 large를 풀 때에도 정렬을 해야한다는 힌트를 얻어서 풀 수 있었지만 말이다.
####################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N = int(input())
parent = [i for i in range(N + 1)]
M = int(input())
queries = []
for _ in range(M):
    x, y = map(int, input().split())
    queries.append((x, y))

if queries:
    queries.sort(key=lambda x: (x[0], -x[1]))
    last_min, last_max = queries[0]
    union(last_min, last_max)
    i = 1
    j = 1
    while i <= N: # 1부터 N까지 쿼리에 따라 union을 실행함
        if i > last_max: # i가 last_max보다 크면 현재 범위를 벗어났으므로,
            while j < M: # 쿼리를 탐색해서 i보다 큰 last_max가 있으면 갱신해줌
                cur_min, cur_max = queries[j]
                j += 1 # 아래 break 때문에 j += 1을 먼저 해줌
                if cur_max > last_max: # 쿼리의 max값이 last_max보다 클 경우 갱신
                    last_max = cur_max
                    last_min = find(cur_min) # last_min은 현재 최고작은 숫자의 부모노드로 갱신해줌
                    break
        if last_min <= i <= last_max:
            union(last_min, i) # last_min과 i를 union한다
        i += 1

    # 부모 테이블을 갱신함
    for i in range(1, N + 1):
        find(i)

print(len(set(parent[1:])))
