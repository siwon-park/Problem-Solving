# 배수로 (25587번)
##########################################################################################
    # 문제: https://www.acmicpc.net/problem/25587
    # 분리 집합, 유니온 파인드
    # 배수로를 합친 다음 매번 쿼리에 대해 일차원적으로 반복문을 돌릴 경우 O(N*M) == O(10^10)이기 때문에 시간초과가 난다.
    # 따라서 처음에 홍수가 날 도시의 수(f)를 구한 다음, 배수로를 합치기 전과 배수로를 합친 다음의 결과를 고려하여
    # 홍수가 날 도시의 수를 업데이트 해주는 방식으로 구현하면 된다.
    # 합치기 전에는 홍수가 나지 않았지만, 합치고 난 뒤에 홍수가 난 경우와 반대로 합치기 전에는 홍수가 났지만 합친 뒤에 홍수가 나지 않는 경우,
    # 그리고 그대로인 경우 등 여러 케이스가 있다. 처음에 이 케이스의 분기를 어떻게 나눠줄지 고민을 많이 했는데, 결국 flag 변수를 사용하였다.
    # 첫 번째 시도에서는 홍수가 나지 않는 경우에 대해 부등호를 잘못 작성하여 틀렸고, 두 번째는 왜 recursionError가 났는지 모르겠다.
    # union 함수를 평소와는 조금 다르게 쓰긴 했는데, 파라미터 밖에 안 바꿨고 union함수 수정과 sys.setrecursionlimit을 추가했더니 통과할 수 있었다.
##########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(_a, _b):
    a, b = find(_a), find(_b)
    if a < b:
        parent[b] = a
        G[a] += G[b]
        A[a] += A[b]
        B[a] += B[b]
    else:
        parent[a] = b
        G[b] += G[a]
        A[b] += A[a]
        B[b] += B[a]


N, M = map(int, input().split())
A = [0] + list(map(int, input().split()))
B = [0] + list(map(int, input().split()))

f = 0  # 홍수로 물에 잠기는 도시의 수
for i in range(1, N + 1):
    if A[i] < B[i]:
        f += 1

parent = [i for i in range(N + 1)]  # 부모 배열
G = [1 for i in range(N + 1)]  # 집합 군의 개수

for _ in range(M):
    q = list(map(int, input().split()))
    if q[0] == 1:
        _a, _b = q[1], q[2]
        pa, pb = find(_a), find(_b)
        if pa != pb:
            fa, fb = 0, 0
            a_flag, b_flag = False, False  # 홍수 여부(처음엔 홍수가 났다고 가정)
            if A[pa] >= B[pa]:  # a가 홍수가 나지 않음
                fa = G[pa]
                a_flag = True
            if A[pb] >= B[pb]:  # b가 홍수가 나지 않음
                fb = G[pb]
                b_flag = True
            ga, gb = G[pa], G[pb]  # 원래의 그룹 수
            union(_a, _b)
            pa, pb = min(pa, pb), max(pa, pb)
            if A[pa] < B[pa]:  # 마을이 홍수가 남
                if a_flag:
                    f += fa
                if b_flag:
                    f += fb
            else:  # 홍수가 나지 않음 => 원래의 그룹 수에서 뺌
                if not a_flag:
                    f -= ga
                if not b_flag:
                    f -= gb
    else:
        print(f)
