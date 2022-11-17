# 미션 도네이션 (25965번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/25965
    # 수학, 사칙연산, 구현
    # 킬, 데스, 어시스트 당 점수를 누적해서 사칙연산하여 도네이션의 값을 계산하는 줄 알았는데,
    # 각 미션 당 계산하여 그 값이 0 이하라면 무시해야 한다.
#########################################################################
import sys
input = sys.stdin.readline

N = int(input())
for _ in range(N):
    M = int(input())
    scores = []
    for _ in range(M):
        s1, s2, s3 = map(int, input().split())
        scores.append((s1, s2, s3))

    k, d, a = map(int, input().split())
    donation = 0
    for i in range(M):
        s1, s2, s3 = scores[i]
        ret = s1 * k + s3 * a - s2 * d
        if ret > 0:
            donation += ret
    print(donation)
