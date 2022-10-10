# 수 이어 쓰기 1(1748번)
##################################################
    # 문제: https://www.acmicpc.net/problem/1748
    # 수학, 구현
    # 0.15초의 시간제한(파이썬은 0.5초)이 있기 때문에 그냥 반복구문으로 풀면 안 된다.
    # 간단하게 생각하면 바로 규칙성을 찾을 수 있다.
    # 1 ~ 9 => 1, 10 ~ 99 => 2, 100 ~ 999 => 3, ....
    # 즉 n의 자리수가 10^(n) - 10^(n-1)개 있다
    # 그러면 이를 활용해 만들 수 있는 수는 (10^(n) - 10^(n-1))*n 개의 자리수를 가진 숫자가 나온다.
    # 즉, 어떤 숫자가 들어왔을 때, 해당 숫자의 자리수 - 1까지의 최대 숫자로 만들 수 있는 자릿수를 구한 다음
    # 해당 숫자의 자리수로 만들 수 있는 10의 제곱수 중 가장 작은 수를 찾고, 해당 숫자에서 그 숫자를 뺀 다음에 자릿수를 곱한 다음
    # 이전에 구했던 자릿수에 더해주면 된다.
##################################################
import sys
input = sys.stdin.readline

N = input().rstrip()
L = len(N)
cnt = 0
for i in range(1, L):
    cnt += (10 ** i - 10 ** (i - 1)) * i

min_num = 10 ** (L - 1)
cnt += (int(N) - min_num + 1) * L

print(cnt)
