# 친구 네트워크(4195번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/4195
    # union-find, 분리집합
    # 9개월 전에 시도했는데 못 풀어서 다시 도전했다. 그래도 여전히 두 차례 틀렸습니다를 받았다
    # 참 재밌는 건 9개월 전에 나랑 생각이 크게 차이가 없다는 것이다. 처음 접근할 때 defaultdict를 활용해야하나 했다가
    # 바로 지웠는데, 9개월 전에 나는 바로 defaultdict를 사용했다.
    # 로직상 아무 문제가 없는 것 같은데 자꾸 틀렸습니다를 받았고, 게시판의 반례 또한 다 통과하는 상태였다.
    # 그러다가 곰곰히 생각하니 내가 주로 쓰는 union함수는 낮은 번호를 가진 노드를 기준으로 통합시키기 때문에
    # 친구 네트워크 관계 수를 통합할 때도 역시 높은 쪽에서 낮은 쪽으로 통합시켜줘야했다.
    # 이를 고려하니 마의 44%구간을 너머 통과할 수 있었다. 대부분 44%에서 틀리는 듯하다.
######################################################################################
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

T = int(input())
for _ in range(T):
    F = int(input())
    parent = [i for i in range(200000)] # 모두 새로운 친구관계만 나올 경우 노드 수가 최대 20개이므로 크기가 20만인 배열을 선언함
    n = 0
    f_dict = dict() # 이름을 키값으로, 값을 등장 순번(노드 번호)으로 사용하는 딕셔너리
    n_dict = dict() # 등장 순번(노드 번호)를 키로, 네트워크에 있는 친구 수를 값으로 사용하는 딕셔너리
    for f in range(F):
        f1, f2 = input().split()
        if f1 not in f_dict:
            f_dict[f1] = n
            n_dict[n] = 1
            n += 1
        if f2 not in f_dict:
            f_dict[f2] = n
            n_dict[n] = 1
            n += 1
        a, b = f_dict[f1], f_dict[f2]
        pa, pb = find_parent(a), find_parent(b)
        if pa != pb: # 새로운 친구관계면
            if pa < pb: # 부모가 더 작은 쪽으로 친구 네트워크를 통합 시킴
                n_dict[pa] += n_dict[pb]
                n_dict[pb] = 0
            else:
                n_dict[pb] += n_dict[pa] 
                n_dict[pa] = 0
            union_parent(a, b) # 합침
        print(n_dict[find_parent(a)])
