# 이진수 덧셈(2729번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/2729
    # 구현
    # 주어지는 이진수를 역순으로 바꾼 다음 두 이진수 중 최대 길이 + 1이 되도록 둘 다 "0"을 붙여준다
    # 그 후 문제에 주어진 조건에 따라 0과 1의 계산 결과와 올리는 수의 개수를 판별하여 계산해주면 된다.
#######################################################################
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for t in range(T):
    A, B = input().rstrip().split()
    N = len(A)
    M = len(B)
    MAX = max(N, M)
    A = A[::-1] + "0" * (MAX - N + 1)
    B = B[::-1] + "0" * (MAX - M + 1)

    ret = "" # 결과
    upper = 0 # 숫자 1의 개수
    for i in range(MAX + 1):
        if A[i] == "1":
            upper += 1
        if B[i] == "1":
            upper += 1
        if upper == 0:
            ret += "0"
        elif upper == 1:
            ret += "1"
            upper = 0
        elif upper == 2:
            ret += "0"
            upper = 1
        elif upper == 3:
            ret += "1"
            upper = 1

    print(int(ret[::-1]))

