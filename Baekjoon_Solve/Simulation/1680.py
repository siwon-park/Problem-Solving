# 쓰레기 수거(1680번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/1680
    # 구현, 시뮬레이션
    # 주어진 문제의 흐름대로 풀면 된다. 자세한 풀이는 주석 참조
################################################################################################
import sys
input = sys.stdin.readline

T = int(input())
for t in range(T):
    W, N = map(int, input().split())

    lst = []
    for _ in range(N):
        xi, wi = map(int, input().split())
        lst.append((xi, wi))

    i = 0
    n = len(lst)
    cur_w = 0
    cur_dist = 0
    total_dist = 0
    while i < n:
        xi, wi = lst[i]
        total_dist += xi - cur_dist
        if cur_w + wi >= W: # 쓰레기의 양이 용량에 도달했거나 그 지점의 쓰레기를 실었을 때 쓰레기차의 용량을 넘게 될 때
            if cur_w + wi == W:
                i += 1
            total_dist += xi # 돌아가서
            cur_dist = 0
            cur_w = 0 # 쓰레기를 비움
        else:
            cur_w += wi
            cur_dist = xi
            i += 1

    total_dist += cur_dist # 더 이상 쓰레기를 실을 지점이 없을 때

    print(total_dist)
