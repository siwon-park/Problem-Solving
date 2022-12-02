# 부분 수열의 합(14225번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/14225
    # 브루트포스
    # 직접 가능한 수의 조합을 찾아서 집합 자료형에 넣고, 완성된 집합을 리스트화하고 정렬한 다음에 반복구문을 돌려서 나올 수 없는 가장 작은 자연수를 반환하였다.
    # 772ms가 나와서 다른 사람의 풀이법을 보니, for 반복문 한번으로 해결하고 있었다.
    # 아마 내 풀이는 N이 좀 컸다면 시간초과로 풀 수 없는 풀이였을 것이다.
################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input().rstrip())
S = list(map(int, input().rstrip().split()))

sum_set = set()


def find_min_num(_set):
    lst = sorted(list(_set))
    min_num = 1
    for num in lst:
        if num != min_num:
            break
        min_num += 1

    return min_num


def dfs(k, s, total):
    if k == N:
        return
    for i in range(s, N):
        sum_set.add(total + S[i])
        dfs(k + 1, i + 1, total + S[i])


dfs(0, 0, 0)
print(find_min_num(sum_set))
###############################################################################
n = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for x in data:
    if target < x: # 만들 수 없는 금액을 찾았을 때 반복 종료
        break
    target += x

print(target)
