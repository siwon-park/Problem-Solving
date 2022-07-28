# 동방 프로젝트(Large) (14595번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/14595
    # 분리집합, 그리디, dp
    # 이 문제의 유형은 분리집합으로 되어있지만, 그리디, DP로도 풀 수 있는 문제였다. 실제로 그리디나 DP로 푼 풀이가 엄청나게 빠르다
    # 5번 시도했고, 도저히 모르겠어서 힌트를 얻어서 풀 수 있었다. + 아마 게시판 반례들이 없었다면 몇 시간은 더 풀어야 했을 것 같다
    # 일단 이 문제의 핵심은 '정렬'이다. 정렬해야한다는 힌트를 못 얻었다면 풀기 힘들었을 것이다.
    # 내 풀이는 일단 쿼리가 있으면, 쿼리의 첫번째 요소들 간 union 연산을 수행한다
    # 그 후, i가 쿼리의 첫번째 요소 최솟값(마지막 최솟값) 이상, 쿼리의 첫번째 요소의 최댓값(마지막 최댓값) 이하인 동안
    # 마지막 최솟값과 union 연산을 수행한다
    # 만약, i가 마지막 최댓값보다 크면, 다음 쿼리의 요소를 탐색해서 i보다 더 큰 마지막 최댓값을 찾고 마지막 최솟값도 구해준다.
    # 위 작업을 i < N 동안 반복하면 된다.
    # 이런 문제를 풀 때, 단순히 유형을 파악하고 또는 유형 힌트를 얻은 다음 무조건 해당 알고리즘으로 접근하는 버릇이 있는데 좋지 않은 것 같다.
    # 다른 알고리즘으로는 풀 수 없는지와, 보다 효율적으로 접근할 수 있는 방안에 대해 파악하고 풀 수 있는 실력이 부족다고 느낀다.
########################################################################################
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
M = int(input())
parent = list(range(N + 1))
queries = []
for _ in range(M):
    x, y = map(int, input().split())
    queries.append((x, y))

queries.sort(key=lambda x: (x[0], -x[1])) # x가 작으면서 y가 큰 기준으로 정렬
if queries:
    last_min, last_max = queries[0]
    union(last_min, last_max)
    i = 1
    j = 1
    while i <= N:
        if i > last_max:
            while j < M:
                cur_min, cur_max = queries[j]
                j += 1
                if cur_max > last_max:
                    last_max = cur_max
                    last_min = find(cur_min)
                    break
        if last_min <= i <= last_max:
            union(last_min, i)
        i += 1

for i in range(1, N + 1):
    find(i)

print(len(set(parent[1:])))

##################################################################
# 그리디 풀이
import sys
p = lambda: sys.stdin.readline().rstrip()
n, m = int(p()), int(p())

li = [list(map(int, p().split())) for _ in range(m)]
li.sort()

ct = r = 1
for f, t in li:
    if f <= ct:
        ct = max(ct, t)
    else:
        r += f - ct
        ct = t
r += n - ct
print(r)
