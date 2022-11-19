# 팰린드롬 만들기 (1254번)
##############################################################
    # 문제: https://www.acmicpc.net/problem/1254
    # 문자열, 브루트포스
    # 처음에 그냥 S에 S[:-1]을 뒤집은 것을 붙인 다음에 끝에서부터 문자열을 잘라서 부분 문자열이 팰린드롬인지 체크하는 문제인줄 알았으나
    # 그게 아니라 S 뒤에 어떠한 문자가 와도 된다. 온 결과가 팰린드롬인지만 확인하면 된다.
    # 즉, 그래서 N번 반복문을 돌면서 S의 0부터 N-1까지의 부분문자열을 역순으로 뒤집어서 매번 붙여준 다음에 해당 문자열이 팰린드롬인지 체크하면 된다.
##############################################################
import sys
input = sys.stdin.readline

S = input().rstrip()


def find_min_pel_len(S):
    N = len(S)
    if S == S[::-1]:
        return N
    else:
        min_len = 2 * N
        for i in range(N):
            new_S = S + S[:i+1][::-1]
            if new_S == new_S[::-1]:
                min_len = min(min_len, N + i + 1)
        return min_len


print(find_min_pel_len(S))
