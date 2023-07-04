import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[b] = a

N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
parent_dict = dict()
owner_dict = dict()
for i in range(N):
    S = input().rstrip().split()
    name = S[-1]
    parent_dict[name] = [i + 1, True]# 왕국의 이름에 해당하는 번호를 딕셔너리에 기록, 초기엔 전부 종주국
    owner_dict[i + 1] = name # i + 1 번째 국가의 주인이 name

for _ in range(M):
    W = input().rstrip().split(",")
    w, l = W[0].split()[-1], W[1].split()[-1] # 승자, 패자
    if W[-1] == "2": # 왕국 2가 승리
        w, l = l, w # 승자와 패자를 스왑
    a, b = find(parent_dict[w][0]), find(parent_dict[l][0])
    if a == b: # 속국과 종주국 간 전쟁
        parent_dict[w], parent_dict[l] = [a, True], [a, False]
    else:
        parent_dict[w][0], parent_dict[l] = a, [a, False]
        for i in range(1, N + 1):
            k = find(i)
            if k == b:
                parent_dict[owner_dict[i]] = [a, False]
        union(a, b)

for i in range(1, N + 1):
    find(i)

print(len(set(parent[1:])))
kingdom_lst = sorted(list(parent_dict.items()))
for i in range(N):
    if kingdom_lst[i][1][1]:
        print(f'Kingdom of {kingdom_lst[i][0]}')