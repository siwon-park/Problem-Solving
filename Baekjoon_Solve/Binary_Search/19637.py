# IF문 좀 대신 써줘 (19637번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/19637
    # 이분탐색
    # bisect_left를 사용하여 어떤 숫자를 왼쪽에 삽입한다 했을 때 가능한 최소 인덱스를 찾아서
    # 해당하는 인덱스 값의 뱃지를 출력하였다.
###########################################################################
import sys
from bisect import bisect_left
input = sys.stdin.readline

N, M = map(int, input().split())
badges = []
lst = []
for _ in range(N):
    inp = input().split()
    badges.append(inp[0])
    lst.append(int(inp[1]))

for _ in range(M):
    q = int(input())
    idx = bisect_left(lst, q)
    print(badges[idx])
