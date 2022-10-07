# 차량 번호판 1 (16968번)
############################################################################################
    # 문제: https://www.acmicpc.net/problem/16968
    # 브루트포스
    # 문제 조건에 맞게 가능한 경우의 수를 곱해주면 되는 문제이다.
############################################################################################
import sys
input = sys.stdin.readline

# 같은 문자나 같은 숫자가 연속해서 등장하면 안 됨
C = input().rstrip()
N = len(C)

last = None # 마지막이 문자였는지 숫자였는지 확인
cnt = 0
for i in range(N):
    if last == None:
        if C[i] == "c":
            cnt = 26
            last = "c"
        else:
            cnt = 10
            last = "d"

    elif last == C[i]:
        if last == "c":
            cnt *= 25
        else:
            cnt *= 9

    elif last != C[i]:
        if C[i] == "c":
            cnt *= 26
        else:
            cnt *= 10
        last = C[i]

print(cnt)

