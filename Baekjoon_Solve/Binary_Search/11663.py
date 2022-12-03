# 선분 위의 점 (11663번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/11663
    # 이분탐색
    # 주어진 리스트를 정렬한 다음에 주어진 선분의 시작점이 리스트에서 제일 왼쪽에 들어갈 인덱스와
    # 끝점이 리스트에서 제일 오른쪽에 들어갈 인덱스를 구한 다음에 오른쪽 인덱스에서 왼쪽 인덱스를 빼주면 된다.
##################################################################################
import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
lst = list(map(int, input().rstrip().split()))
lst.sort()

for _ in range(M):
    s, e = map(int, input().rstrip().split())
    l_idx = bisect_left(lst, s)
    r_idx = bisect_right(lst, e)
    print(r_idx - l_idx)
