# 용돈 관리(6236번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/6236
    # 이분탐색, 매개변수 탐색
    # 문제 지문을 잘못 이해, 실수를 해서 시간을 좀 잡아먹었다.
    # 이분 탐색이라고 해서 무지성으로 정렬을 해버리는 바람에 문제를 풀 수 없었다.
    # s가 max(lst)인 이유는 돈을 인출해도 그 날 써야할 금액보다 작으면 물건을 살 수 없는데도 불구하고, 인출하여 물건을 산 것처럼 로직이 작동하기 때문에
    # s는 무조건 lst의 최댓값이어야 한다
    # 그리고 e는 100000*10000이어야 한다. 10만일 동안 1만 금액을 사용할 수 있는 최대의 경우
    # 그리고 정확히 M번 인출해야한다고 했음에도 불구하고 cnt == M을 하지 않는 이유는 
    # 문제에서 돈이 남아서 그날 쓸 금액보다 커서 충분함에도 불구하고 M을 맞추기 위해 넣을 수도 있다고 했고 s가 lst의 최댓값에서 출발해서 탐색하므로
    # cnt <= M이라면 cnt == M을 보장하도록 만들 수 있는 것이다.
#######################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
lst = []
for _ in range(N):
    lst.append(int(input().rstrip()))

def binary_search():
    s, e = max(lst), int(1e9)
    opt = 0
    while s <= e:
        mid = (s + e) // 2
        cnt = 1 # 현재 인출 횟수
        cur_money = mid # 현재 인출한 돈
        for i in range(N):
            if cur_money < lst[i]:
                cnt += 1
                cur_money = mid
            cur_money -= lst[i]
        if cnt <= M:
            e = mid - 1
            opt = mid
        else:
            s = mid + 1
    return opt

print(binary_search())
