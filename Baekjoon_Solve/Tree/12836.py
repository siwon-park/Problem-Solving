# 가계부(Easy) (12836번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/12836
    # 세그먼트 트리
    # 파이썬으로도 세그먼트 트리를 익히기 위해서 풀어보았다.
    # easy난이도는 브론즈라서 조금 놀랐다.
###########################################################################
import sys, math
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

class SegmentTree:

    tree = None

    def __init__(self, n):
        height = math.ceil(math.log(n, 2)) + 1
        node_count = round(math.pow(2, height)) - 1
        self.tree = [0] * node_count


    def init(self, arr, node, start, end):
        if start == end:
            self.tree[node] = arr[start]
            return self.tree[node]

        mid = (start + end) // 2
        self.tree[node] = self.init(arr, node * 2, start, mid) + self.init(arr, node * 2 + 1, mid + 1, end)
        return self.tree[node]


    def sum(self, node, left, right, start, end):
        if right < start or end < left:
            return 0

        elif left <= start and end <= right:
            return self.tree[node]

        mid = (start + end) // 2
        return self.sum(node * 2, left, right, start, mid) + self.sum(node * 2 + 1, left, right, mid + 1, end)


    def update(self, node, start, end, index, value):
        if index < start or end < index:
            return self.tree[node]

        elif index == start and end == index:
            self.tree[node] += value
            return self.tree[node]

        mid = (start + end) // 2
        self.tree[node] = self.update(node * 2, start, mid, index, value) + self.update(node * 2 + 1, mid + 1, end, index, value)
        return self.tree[node]


N, Q = map(int, input().split())

segment_tree = SegmentTree(N)

for _ in range(Q):
    o, p, xq = map(int, input().split())
    if o == 1:
        segment_tree.update(1, 1, N, p, xq)
    else:
        ret = segment_tree.sum(1, p, xq, 1, N)
        print(ret)
