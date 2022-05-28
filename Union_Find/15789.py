# CTP 왕국은 한솔 왕국을 이길 수 있을까?(15789번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/15789
    # 분리집합
    # 평범한 분리집합 문제였는데 거의 1시간을 썼다. 나의 큰 실수 때문이다.
    # 최초로 동맹 간 힘의 크기를 딕셔너리에 담는 과정에서 엄청난 실수를 저질렀고, 눈치채기까지 1시간이나 걸렸던 것이다.
    # 딕셔너리에 키값으로 가장 최상의 부모노드에 대해서 힘의 크기를 담았어야 했는데, 바로 위의 부모를 키값으로 해당 행동을 하고 있었던 것이다.
    # 다음부터는 이런 실수를 하지 말아야겠다.
################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a, b = find_parent(a), find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
for _ in range(M):
    X, Y = map(int, input().split())
    union_parent(X, Y)

C, H, K = map(int, input().split()) #  K번의 동맹 맺을 기회를 모두 사용하지 않아도 됨

p_dict = dict()
for i in range(1, N+1):
    pi = find_parent(i)
    p_dict[pi] = p_dict.get(pi, 0) + 1
    # p_dict[parent[i]] = p_dict.get(parent[i], 0) + 1 # 바로 위의 부모를 대상으로 동맹의 크기를 기록하고 있었음...

lst = sorted(list(p_dict.items()), key=lambda x: -x[1])

k = 0 # 동맹 횟수
pc = find_parent(C) # CTP 왕국의 부모 노드 번호
ph = find_parent(H) # 한솔 왕국의 부모 노드 번호

for i in range(len(lst)):
    if k >= K:
        break
    pc, ph = find_parent(C), find_parent(H)
    pn = lst[i][0]
    if pn != ph and pn != pc:
        if pn < pc:
            p_dict[pn] += p_dict[pc]
            p_dict[pc] = 0
        else:
            p_dict[pc] += p_dict[pn]
            p_dict[pn] = 0
        union_parent(C, pn) # 동맹을 맺음
        k += 1

print(p_dict[find_parent(C)])
# print(parent)
# print(p_dict)
