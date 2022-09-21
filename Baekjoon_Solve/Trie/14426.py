# 접두사 찾기(14426번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/14426
    # 트라이, 문자열
    # 그냥 파이썬의 startswith함수를 썼다면 시간초과 없이 바로 풀었을 테지만, 일부러 트라이를 연습하려고 풀어보았다.
##################################################################
import sys
input = sys.stdin.readline

class Node:

    key = None
    data = None
    child_node = None
    end_of_word = None

    def __init__(self, key):
        self.key = key
        self.child_node = dict()
        self.end_of_word = False

class Trie:

    root_node = None

    def __init__(self):
        self.root_node = Node(None)

    def insert(self, S):

        node = self.root_node

        for s in S:
            node.child_node[s] = node.child_node.get(s, Node(s))
            node = node.child_node[s]

        node.data = S
        node.end_of_word = True

    def search(self, S):

        node = self.root_node

        for s in S:
            if node.child_node.get(s) == None:
                return False

            node = node.child_node.get(s)

        return node.end_of_word

    def startswith(self, prefix):

        node = self.root_node

        for s in prefix:
            node = node.child_node.get(s)
            if node == None:
                return False

        return True

N, M = map(int, input().split())
targets = []
trie = Trie()
cnt = 0

for _ in range(N):
    _target = input().rstrip()
    targets.append(_target)
    trie.insert(_target)

for _ in range(M):
    _prefix = input().rstrip()
    if trie.startswith(_prefix):
        cnt += 1

print(cnt)
