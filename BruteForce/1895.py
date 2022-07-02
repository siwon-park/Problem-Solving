# 필터(1895번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/1895
    # 브루트포스
    # R, C의 범위가 작아서 4중 for 구문 완전탐색으로 구현해도 충분히 시간 안에 통과 가능하다.
    # 최악의 경우에도 O(40*40*3*3)의 시간 복잡도를 가진다.
    # 처음에 문제를 잘못 읽어서 틀렸는데, 3x3칸에서 T이상인 수가 최대인 경우가 몇인지 구하는 줄 알았는데,
    # 3x3배열에서 중앙값이 T이상인 배열의 개수를 구하는 문제였다.
######################################################################################
import sys
input = sys.stdin.readline

R, C = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]
T = int(input())

filter_cnt = 0
for r in range(R - 2):
    for c in range(C - 2):
        filtered = []
        for i in range(3):
            for j in range(3):
                filtered.append(board[r + i][c + j])
        filtered.sort()
        if filtered[9//2] >= T:
            filter_cnt += 1

print(filter_cnt)
