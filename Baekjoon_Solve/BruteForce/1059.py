# 좋은 구간(1059번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/1059
    # 브루트포스
    # 집합 S에서 n이 들어있으면 좋은 구간을 만들지 못하니 0을 출력하면 되고,
    # 아니라면, 집합 S에서 1 <= a < n인 a를 찾고, n < b <= 1000인 b를 찾아서
    # 2중 for구문을 돌려서 반복 횟수를 출력하면 된다.
######################################################################################
import sys
input = sys.stdin.readline

L = int(input())
S = list(map(int, input().split()))
n = int(input())

def find_cnt(n):
    if n in S:
        return 0
    S.sort()
    min_num = 0 # 집합 S의 최솟값
    max_num = n # 집합 S의 최댓값
    for i in range(L):
        if S[i] > n:
            max_num = S[i]
            break

    for i in range(L - 1, -1, -1):
        if S[i] < n:
            min_num = S[i]
            break

    max_num = n + 1 if max_num == n else max_num
    min_num = min_num + 1 if min_num != n else min_num

    cnt = 0
    for i in range(min_num, n + 1):
        for j in range(n, max_num):
            if i != j:
                cnt += 1

    return cnt

print(find_cnt(n))
