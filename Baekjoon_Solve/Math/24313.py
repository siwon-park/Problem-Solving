# 알고리즘 수업 - 점근적 표기 1 (24313번)
import sys
input = sys.stdin.readline

a1, a0 = map(int, input().rstrip().split())
c = int(input().rstrip())
n0 = int(input().rstrip())

if (c - a1) * n0 >= a0 and a1 <= c:  # 기울기 비교 a1*n - a0 <= c*n 이려면 a1 <= c 이어야 함
    print(1)
else:
    print(0)

