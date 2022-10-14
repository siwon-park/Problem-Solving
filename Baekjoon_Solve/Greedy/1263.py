# 시간 관리(1263번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/1263
    # 그리디, 정렬
    # 주어진 t, s를 마감 시간을 기준으로 역순 정렬한다.
    # 현재 가장 늦은 일 시작 시간(lt)을 lst[0][1]로 잡고, 현재의 마감 시간과 비교하여 더 작은 시간을 고른 다음
    # t를 뺀 값을 lt로 설정한다. 만약 여기서 lt가 0보다 작다면 0시부터 시작해도 일을 끝낼 수 없기 때문에 -1을 반환한다.
################################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    T, S = map(int, input().split())
    lst.append((T, S))

lst.sort(key=lambda x: -x[1])

def check():
    lt = lst[0][1]
    for i in range(N):
        t, s = lst[i]
        lt = min(lt, s) - t
        if lt < 0:
            return -1

    return lt

print(check())
