# 완전 이진 트리(9934번)
############################################################
    # 문제: https://www.acmicpc.net/problem/9934
    # 트리, 재귀
    # 중위순회(inorder traversal)의 결과를 받았을 때, 해당 결과를 토대로 이진 트리를 구성할 수 있는가를 확인하는 문제
    # 문제에서 주어진 이진 트리가 완전 이진 트리(complete binary tree)가 아니라 포화 이진 트리(full binary tree)여서 쉽게 풀 수 있었다.
    # 포화 이진 트리는 노드의 수가 2^k-1개이므로 재귀적으로 접근했을 때, 자른 배열의 N//2에 위치에 있는 것이 부모 노드(루트 노드)이다.
    # 따라서 inorder의 N//2를 tree의 i번째 인덱스에 기록해주고, 재귀적으로 함수를 2번 넘겨준다.
    # 1) i의 왼쪽 자식 노드의 인덱스는 2*i이므로 함수 인자로 2*i를 넘겨주고, 배열의 길이는 N//2, 배열을 N//2까지 자른 왼쪽 서브트리를 넘겨준다.
    # 2) i의 오른쪽 자식 노드의 인덱스는 2*i+1이므로 함수 인자로 2*i+1, 배열의 길이는 N//2, 배열을 N//2+1부터 끝까지 자른 오른쪽 서브트리를 넘겨준다.
    # N==0이되면 해당 배열의 길이는 0이므로 인덱스 접근을 할 수 없으므로 함수의 호출을 종료한다.
############################################################
import sys
input = sys.stdin.readline

K = int(input())
inorder = list(map(int, input().split()))
N = len(inorder)

tree = [0] * (N+1)
def make_tree(i, N, arr):
    if N == 0:
        return
    tree[i] = arr[N//2]
    make_tree(2*i, N//2, arr[:N//2])
    make_tree(2*i+1, N//2, arr[N//2+1:])
    
make_tree(1, N, inorder)

for i in range(1, K+1):
    print(*tree[2**(i-1):2**i])
