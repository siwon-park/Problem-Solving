# 트리 순회(1991번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/1991
    # 트리, 재귀
    # 트리의 순회를 배우고 나니까 쉽게 풀 수 있는 문제인줄 알았는데,
    # 자세히 보니 완전 이진 트리가 아니어서 트리를 저장하는데 여러 시도를 하느라 애먹었다.(사실 문제를 제대로 또 안 읽어서 생긴 문제)
    # 딕셔너리 형태로 트리를 저장하니까 굉장히 쉽게 풀렸다.
#######################################################
import sys
input = sys.stdin.readline

# 전위순회
def preorder(v):
    if v == ".":
        return
    print(v, end = "")
    preorder(tree[v][0])
    preorder(tree[v][1])

# 중위순회
def inorder(v):
    if v == ".":
        return
    inorder(tree[v][0])
    print(v, end = "")
    inorder(tree[v][1])

# 후위순회
def postorder(v):
    if v == ".":
        return
    postorder(tree[v][0])
    postorder(tree[v][1])
    print(v, end = "")

N = int(input())
tree = {}
for i in range(1, N+1):
    n1, n2, n3 = input().rstrip().split()
    tree[n1] = [n2, n3]
preorder("A")
print()
inorder("A")
print()
postorder("A")
