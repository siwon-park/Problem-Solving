# 부품 대여장 (21942번)
"""
    문제: https://www.acmicpc.net/problem/21942
    문자열, 파싱, 자료구조, 해시맵
    문자열 파싱만 잘하면 풀 수 있는 문제.
    대여 기간과 더불어 주어진 시간을 분으로 전부 환산하였다.
    그리고 월을 분으로 환산할 때 사용하기 위해 각 월까지의 누적 일을 month_dp에 저장하였다.
    어차피 문제에서 주어진 연도는 2021년도 뿐이라고 했으므로
    월, 일, 시간을 분으로 환산하면 된다.
    딕셔너리 자료형(맵 자료형)안에 또 딕셔너리를 만든다.
    첫 번째 계층의 키는 이름이고, 두 번째 계층의 키는 제품명이고, 값은 시간이다.
    만약 이름에 해당하는 제품의 값이 None이면 처음 빌리는 것이므로 시간 값을 저장하고
    아니라면, 현재 시간에서 딕셔너리에 들어있는 값을 뺀다.
    뺀 값이 대여 기간을 초과한다면 이름의 키로, 벌금을 값으로 하는 딕셔너리에 누적한다.
    이 때 주의할 점은 이름에 해당하는 제품과 시간 쌍을 딕셔너리에서 제거해줘야 한다.
    딕셔너리를 리스트화하여 길이가 0이라면 -1을 출력하고
    아니라면 이름을 오름차순으로 정렬하여 출력하면 끝.
"""
import sys
input = sys.stdin.readline

N, L, F = input().split()
N = int(N)
F = int(F)

month_dict = {0: 0, 1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
month_dp = [0] * 13
for i in range(1, 13):
    month_dp[i] += (month_dp[i - 1] + month_dict[i - 1])

loan_dict = dict()
L = L.replace("/", " ")
L = L.replace(":", " ")
L = L.split()
L = int(L[0]) * 24 * 60 + int(L[1]) * 60 + int(L[2])
P_dict = dict()
for i in range(N):
    DATE, TIME, P, M = input().split()
    yyyy, MM, dd = map(int, DATE.split("-"))
    hh, mm = map(int, TIME.split(":"))
    time = (dd + month_dp[MM]) * 24 * 60 + hh * 60 + mm  # 분
    loan_dict[M] = loan_dict.get(M, dict())
    if loan_dict[M].get(P) == None:
        loan_dict[M][P] = time
    else:
        ot = time - loan_dict[M][P]
        if ot > L:
            P_dict[M] = P_dict.get(M, 0) + (ot - L) * F
        del loan_dict[M][P]

lst = list(P_dict.items())
if not lst:
    print(-1)
else:
    lst.sort(key=lambda x: x[0])
    for items in lst:
        print(*items)
