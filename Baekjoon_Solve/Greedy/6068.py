# 시간 관리하기(6068번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/6068
    # 그리디, 정렬
    # 작업이 끝나는 시간을 기준으로 오름차순 정렬해준 다음
    # 작업 시작 시간 t를 0부터 작업의 첫번째 요소의 끝나는 시간과 걸리는 시간의 차이값까지 탐색하여
    # 모든 작업을 끝낼 수 있는 시작 시간 중 가장 큰 시간을 출력하였다.
    # 모든 풀이 중에 1000ms로 내가 가장 느렸다. 그리디라기 보다는 정렬 + 완전탐색 방식으로 풀어서 그런듯하다.
    # 시간초과가 발생하는 테스트 케이스가 없어서 통과할 수 있었던 것 같다. 왜냐하면 최악의 경우 99999 * 1000의 시간이 걸리기 때문에 이는 대략 O(10^9)이다.
    # 다른 사람의 풀이를 보니까 엄청 빠른 속도로 해결하고 있었는데,
    # 작업이 끝나는 시간을 기준으로 내림차순 정렬해서 사용하고 있었다. 그렇게 할 경우 O(N)의 시간 복잡도로 해결할 수 있다.
    # 다른 사람의 풀이를 참조하여 코드를 다시 작성해서 첨부하였다.
###########################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    T, S = map(int, input().split())
    lst.append((T, S))

lst.sort(key=lambda x: x[1]) # 작업이 끝나는 시간 기준으로 오름차순 정렬

def check():
    mwt = -1
    for t in range(lst[0][1] - lst[0][0] + 1):
        wt = t
        for i in range(N):
            if wt + lst[i][0] <= lst[i][1]:
                wt += lst[i][0]
            else:
                break
        else:
            mwt = max(mwt, t)
    return mwt

print(check())

#############################################################################################

import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    T, S = map(int, input().split())
    lst.append([T, S])

lst.sort(key=lambda x: -x[1]) # 작업이 끝나는 시간 기준으로 내림차순 정렬

def check():
    max_work_time = lst[0][1] - lst[0][0] # 가장 늦게 시작하는 작업 시간
    for i in range(1, N):
        if max_work_time < lst[i][1]: # 최근 가장 늦게 시작하는 작업 시간이 현재 작업의 끝나는 시간보다 빠르면
            lst[i][1] = max_work_time # 현재 작업의 끝나는 시간을 최근 가장 늦게 시작하는 작업 시간으로 앞당김
        max_work_time = lst[i][1] - lst[i][0]
    if max_work_time < 0:
        return -1
    return max_work_time

print(check())
