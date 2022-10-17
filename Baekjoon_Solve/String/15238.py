# Pirates(15238번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/15238
    # 문자열
    # 가장 많이 등장한 문자열과 빈도 수를 출력하면 되는 문제
##################################################################
import sys
input = sys.stdin.readline

N = int(input())
S = input().rstrip()

dic = dict()
for i in range(N):
    dic[S[i]] = dic.get(S[i], 0) + 1

lst = list(dic.items())
lst.sort(key=lambda x: -x[1])

print(*lst[0])
