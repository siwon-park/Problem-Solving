# 로마 숫자 만들기(16922번)
##########################################################
    # 문제: https://www.acmicpc.net/problem/16922
    # 재귀, 백트랙킹
    # 로마 숫자 4개를 이용하여 만들 수 있는 숫자의 개수를 구하는 문제이다.
    # 중요한 것은 로마자를 이용해서 숫자를 만들 때, 자기자신보다 작은 수는 앞에 올 수 없다는 것이다.
    # 따라서 중복 조합을 구하되, 앞에 오는 숫자가 자기 자신보다 크지 않은 경우만 구하면 된다.
##########################################################
import sys
input = sys.stdin.readline

def dfs(s, k, tmp_sum):
    global cnt
    if k == N:
        if tmp_sum not in comb:
            comb.add(tmp_sum)
            cnt += 1
        return
    if s == 4:
        return
    for i in range(s, 4):
        dfs(i, k+1, tmp_sum+arr[i])

N = int(input())
arr = [1, 5, 10, 50]
cnt = 0
comb = set()
dfs(0, 0, 0)
print(cnt)
