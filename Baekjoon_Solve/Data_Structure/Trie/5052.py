# 전화번호 목록(5052번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/5052
    # 트라이, 문자열
    # 트라이 알고리즘에 대해 배워보기 위해 시도하였다.
    # 예전에 파이썬으로 구현한적 있었는데 다 까먹어서 구글링을 통해 구현하였다.
    # 그런데 이 문제는 굳이 트라이로 구현하지 않아도 충분히 빠른 시간 안에 풀 수도 있는 문제였다.
    # 트라이 풀이가 더 비효율적인 경우이다. 트라이에 대해 정리를 하되 어떨 때 써야하는지도 익혀놓아야겠다.
#####################################################################################
import sys
input = sys.stdin.readline

class Node:

    key = None
    data = None
    child_node = None
    end_of_word = False

    def __init__(self, key):
        self.key = key
        self.child_node = dict()
        self.end_of_word = False


class Trie:

    root_node = None

    def __init__(self):
        self.root_node = Node(None)

    # 삽입 함수
    def insert(self, S: str) -> None:
        node = self.root_node

        for s in S:
            node.child_node[s] = node.child_node.get(s, Node(s))
            node = node.child_node[s]

        node.data = S
        node.end_of_word = True

    # 찾기 함수
    def search(self, S: str) -> bool:
        node = self.root_node

        for s in S:
            if node.child_node.get(s) == None:
                return False
            node = node.child_node.get(s)

        return node.end_of_word

    def start_with(self, prefix: str) -> list:
        node = self.root_node
        words = [] # prefix로 시작하는 단어 배열

        for s in prefix:
            node = node.child_node.get(s)
            if node == None:
                return words

        node = [node]
        nxt_node = []

        while True:
            for _node in node:
                if _node.data:
                    words.append(_node.data)
                nxt_node.extend(list(_node.child_node.values())) # values는 노드 객체들이므로 노드들이 삽입됨

            if len(nxt_node):
                node = nxt_node
                nxt_node = []
            else:
                break

        return words

def check():
    for s in lst:
        ret = trie.start_with(s)
        if len(ret) != 1:
            return False
    return True

t = int(input())
for tc in range(t):
    trie = Trie()

    n = int(input())
    lst = []
    for _ in range(n):
        call_num = input().rstrip()
        lst.append(call_num)
        trie.insert(call_num)

    flag = check()
    if flag:
        print("YES")
    else:
        print("NO")
