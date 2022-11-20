# 기술 연계마스터 임스(25497번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/25497
    # 구현, 스택
    # 굳이 스택을 쓰지 않고, L과 S의 카운트 배열을 활용하여 구현할 수도 있는 간단한 문제이다.
######################################################################
import sys
input = sys.stdin.readline

N = int(input().rstrip())
skills = input().rstrip()

# 사전 기술을 먼저 쓰지 않으면 그 이후의 기술은 카운트 X
pre = [0, 0]  # L, S

cnt = 0
for s in skills:
    if "1" <= s <= "9":
        cnt += 1
    elif s == "S":
        pre[1] += 1
    elif s == "L":
        pre[0] += 1
    else:
        if s == "R":
            if pre[0]:
                pre[0] -= 1
                cnt += 1
            else:
                break
        elif s == "K":
            if pre[1]:
                pre[1] -= 1
                cnt += 1
            else:
                break

print(cnt)
