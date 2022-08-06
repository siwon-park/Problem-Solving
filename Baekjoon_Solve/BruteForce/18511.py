# 큰 수 구성하기(18511번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/18511
    # 브루트포스, 재귀
    # 숫자를 문자열로 붙여서 N보다 크면 return하게끔 함수를 구현하였다.
    # ret배열에 N보다 숫자가 작은 것은 다 담은 다음에 역순으로 정렬하여 제일 처음 나오는 요소를 출력하였다.
    # 다 풀고 다른 사람의 풀이를 보니까 굳이 문자열을 사용하지 않고 숫자만으로 10을 곱하고 k를 더하면서 해결할 수도 있었다.
    # 나는 왜 이런 방법을 생각못했는지 조금 아쉽다... 파이썬이 문자열-숫자 간 변환이 쉬워서 망정이지 다른 언어였으면 내 풀이는 비효율적일지도 모르겠다...
##############################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

ret = []
N, K = map(int, input().split())
lst = input().split()

def dfs(num):
    if int(num) > N:
        return
    ret.append(int(num))
    for i in range(K):
        dfs(num + lst[i]) # dfs(10*num + lst[i])
dfs("0")
ret.sort(key=lambda x: -x)
print(ret[0])
