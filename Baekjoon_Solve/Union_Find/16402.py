# 제국(16402번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/16402
    # 분리집합, 딕셔너리(맵)
    # 진짜 틀린 이유를 못찾아서 엄청 많은 시간을 소비했다
    # 일단 문제도 제대로 읽지 않고 바로 시작한 것도 화근이었다...
    # 침착하게 풀었으면 많은 시간과 시행착오를 많이 거치지 않고 풀 수 있었을 텐데 그러지 못하였다.
    # 왕국의 이름에 해당하는 번호와 종주국 여부를 기록하는 딕셔너리와 맨 처움 초기 국가의 주인이 누구인지 기록한 딕셔너리를 사용하였다.
    # 자세한 풀이는 주석을 참조
################################################################################################
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
    else: # 일반적인 전쟁(만약 속국이 이기면 속국의 상태는 그대로(종주국이어도 마찬가지)이니 갱신 X, 지는 쪽은 그것과 상관없이 False로 바꿈)
        parent_dict[w][0], parent_dict[l] = a, [a, False]
        for i in range(1, N + 1):
            k = find(i) 
            if k == b: # i번 국가의 종주국 번호가 b이면
                parent_dict[owner_dict[i]] = [a, False] # i번 국가의 상태를 갱신해준다
        union(a, b)

for i in range(1, N + 1):
    find(i)

# print(parent)
# print(parent_dict)

print(len(set(parent[1:])))
kingdom_lst = sorted(list(parent_dict.items()))
for i in range(N):
    if kingdom_lst[i][1][1]:
        print(f'Kingdom of {kingdom_lst[i][0]}')
