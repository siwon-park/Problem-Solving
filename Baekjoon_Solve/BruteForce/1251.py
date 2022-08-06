# 단어 나누기(1251번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/1251
    # 브루트포스
    # DFS로 숫자 조합을 만들어야하나 고민했는데, 생각해보니 그렇게 어렵게 할 필요가 없었다.
    # 3중 for구문으로 충분히 쉽게 해결할 수 있는 쉬운 문제였다. 
###############################################################################
import sys
input = sys.stdin.readline

S = input().rstrip()
N = len(S)
ret = []
for i in range(N - 2):
    first = S[:i+1]
    for j in range(i + 1, N - 1):
        second = S[i+1:j+1]
        for k in range(j + 1, N):
            third = S[j+1: N]
            ret.append(first[::-1] + second[::-1] + third[::-1])
ret.sort()
print(ret[0])
