# 집합의 표현(1717번)
####################################################################
    # 문제: https://www.acmicpc.net/problem/1717
    # 자료구조, 집합
    # find, union을 할 줄 알면 매우 쉽게 풀 수 있다.
    # 처음에 자꾸 recursion error find_parent함수에서 발생하길래 왜지 하고 봤더니
    # union_parent에서 a, b = find_parent(a), find_parent(b)를 해야하는 것을
    # parent[a]로 해버리는 바람에 같은 집합에 속하는 다른 원소가 부모 노드가 합쳐졌을 때
    # 갱신이 안 되는 오류가 발생하기 때문에 종국에는 find_parent에서 재귀 깊이 에러가 발생하는 것이다.
####################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]

def union_parent(a, b):
    a, b = find_parent(a), find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
parent = [i for i in range(n + 1)]
for _ in range(m):
    cmd, a, b = map(int, input().split())
    if not cmd:
        union_parent(a, b)
    else:
        a, b = find_parent(a), find_parent(b)
        if a != b:
            print("NO")
        else:
            print("YES")
