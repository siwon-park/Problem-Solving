# 귀여운 라이언 (15565번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/15565
    # 투 포인터
    # 일반적인 방식으로 투 포인터를 구현하여 문제를 해결하였다.
    # 크게 문제 내에 특이점은 없어서 내 풀이보다 2배 빠른 풀이를 소개한다. 아이디어가 참 괜찮다고 생각한다.
    # 인덱스에 해당하는 리스트 값이 1이라면 해당 인덱스를 새로운 배열에 계속 담아서
    # 만약 새로운 배열의 길이가 K 이하라면 -1을 출력하고, 아니라면 새로운 배열의 구간 길이가 K개인 것 중 인덱스 차이가 가장 작은 값을 구하면 된다.
########################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
lst = list(map(int, input().split()))

INF = sys.maxsize
l = INF
cnt = 0
e = 0
for s in range(N):
    while e < N and cnt < K:
        if lst[e] == 1:
            cnt += 1
        e += 1
    if cnt == K:
        l = min(l, e - s)
    if lst[s] == 1:
        cnt -= 1

if l == INF:
    print(-1)
else:
    print(l)
######################################################################################
N, K = map(int, input().split())
L = list(map(int, input().split()))

LL = []
for i in range(N):
    if L[i] == 1:
        LL.append(i)  # 인덱스를 담음

if len(LL) < K:  # 인덱스를 담은 배열의 길이가 K 이하라면 라이언 인형이 K 이상인 집합이 없으므로 -1을 출력
    print(-1)
else:  # 새로운 배열의 구간 길이가 K개인 것 중 인덱스 차이가 가장 작은 값을 구함
    print(min((LL[i + K - 1] - LL[i] + 1 for i in range(len(LL) - K + 1))))
