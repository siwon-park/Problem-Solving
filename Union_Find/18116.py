# 로봇 조립(18116번)
###############################################################################################
    # 문제: https://www.acmicpc.net/problem/18116
    # union-find, 분리집합
    # 처음에 인덱스 초과는 N이 로봇의 개수가 아닌, 명령의 개수였기 때문이고,
    # 두번째 1%에서 틀렸습니다를 받은 이유는 중복 또는 이미 부모가 같은 대도 불구하고 입력으로 주어지는 경우가 있기 때문이었던 것 같다.
    # 이를 처리해주니 통과할 수 있었다.
    # 이외에는 크게 신경 쓸 게 없는 일반적인 union-find 문제이다.
###############################################################################################
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

N = int(input())
parent = [i for i in range(int(1e6) + 1)]
p_dict = dict()
for i in range(1, int(1e6) + 1):
    p_dict[i] = 1

for _ in range(N):
    query = input().rstrip().split()
    if query[0] == "I":
        q1, q2 = int(query[1]), int(query[2])
        pq1, pq2 = find_parent(q1), find_parent(q2)
        if pq1 != pq2:
            if pq1 < pq2:
                p_dict[pq1] += p_dict[pq2]
                p_dict[pq2] = 0
            else:
                p_dict[pq2] += p_dict[pq1]
                p_dict[pq1] = 0
            union_parent(q1, q2)
    elif query[0] == "Q":
        print(p_dict[find_parent(int(query[1]))])
