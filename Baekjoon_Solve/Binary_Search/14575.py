# 뒤풀이 (14575번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/14575
    # 이분탐색, 매개변수 탐색
    # 최대 탐색 한계는 T이고, 최소는 1이다.
    # 만약 mid의 값이 l보다 작으면 조건에 만족하지 못하니까 mid값을 늘리기 위해 s를 mid + 1로 옮긴다.
    # 그리고, 누적 L값과 누적 R값을 두고 mid값과 l, r 중 작은 값을 각 각에 더해준다.
    # 만약 T 값이 누적 L값과 누적 R값의 사이면서 flag == True를 만족하면 합이 T인 S를 만족할 수 있으므로, 범위를 좁혀서 탐색해본다.
#####################################################################################
import sys
input = sys.stdin.readline

N, T = map(int, input().split())
lst = []
for _ in range(N):
    L, R = map(int, input().split())
    lst.append((L, R))

S = -1
s = 1
e = T
while s <= e:
    mid = (s + e) // 2
    R = 0 # 상한의 누적값
    L = 0 # 하한의 누적값
    flag = True
    for i in range(N):
        l, r = lst[i]
        if mid < l: # l보다 작으면 조건을 만족 못 함
            flag = False
            break
        R += min(mid, r) # mid와 r 중 작은 값을 상한의 누적값에 합산함
        L += min(mid, l) # mid와 l 중 작은 값을 하한의 누적값에 합산함
    if L <= T <= R and flag: # 조건에 부합한다면 최대 탐색 한계를 줄여서 탐색함
        e = mid - 1
        S = mid
    else:
        s = mid + 1

print(S)
