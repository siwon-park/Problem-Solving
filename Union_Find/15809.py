# 전국시대(15809번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/15809
    # 분리 집합
    # 서로 멸망하는 경우를 제외하고는 전쟁을 하든, 동맹을 하든 union을 해줬고
    # 조건에 따라 합쳐진 두 노드의 부모 노드의 병력 값을 갱신해주었다. 그 후 두 노드의 병력들을 각 각 0으로 만들었다.
    # 멸망할 경우에는 합치지는 않고 두 노드의 병력만 모두 0으로 만들었다.
############################################################################
import sys
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
A = [0] + [int(input().rstrip()) for _ in range(N)] # 0번 국가의 병력은 0

for _ in range(M):
    O, P, Q = map(int, input().split()) # 동맹, P국가, Q국가
    if O == 1: # 동맹
        p, q = find_parent(P), find_parent(Q)
        union_parent(P, Q)
        merge = A[p] + A[q] # 동맹이 될 경우 두 국가의 병력을 합침
        A[p], A[q] = 0, 0 # 현재 두 국가의 부모 국가의 병력을 모두 0으로 만듦
        A[find_parent(P)] = merge # 동맹이된 두 국가의 부모 국가의 병력을 merge값으로 갱신
    else:
        p, q = find_parent(P), find_parent(Q)
        if A[p] == A[q]: # 병력이 같으면 모두 멸망
            A[p], A[q] = 0, 0
        else:
            union_parent(P, Q)
            left = abs(A[p] - A[q]) # 남은 병력
            A[p], A[q] = 0, 0
            A[find_parent(P)] = left

left_A = []
left_cnt = 0
for i in range(1, N + 1):
    if A[i]:
        left_cnt += 1
        left_A.append(A[i])
left_A.sort()

print(left_cnt)
print(*left_A)
