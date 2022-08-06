# 소-난다!(19699번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/19699
    # 백트랙킹, 에라토스테네스의 체
    # 1 <= M <= N <= 9이고, 1 <= H[i] <= 1000이므로 합으로 최대 9000이라는 숫자까지 나올 수 있다.
    # 따라서 9000이하의 소수를 에라토스테네스의 체로 구한 뒤, 백트랙킹으로 소 조합에 따른 몸무게 합을 중복 없이 오름차순으로 출력하면 된다.
    # 처음에 H를 정렬하고 시작해서 결과가 당연히 오름차순이겠거니 생각했는데, 그게 아니었고 틀렸습니다 판정을 받았다.
    # 그래서 결과를 정렬하니 맞았습니다 판정을 받았다.
    # 어차피 최종 결과를 정렬해야한다면 H를 정렬할 필요가 없으니 H를 정렬하지 않고 최종 결과만 정렬하니 시간을 조금 앞당길 수 있었다.
###########################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
H = list(map(int, input().split()))

check = [False] * 9001 # 중복 방지 체크용
prime = [True] * 9001
prime[0] = prime[1] = False
for i in range(2, 9001):
    if prime[i]:
        j = 2
        while i * j <= 9000:
            prime[i * j] = False
            j += 1

def combine(k, s, total):
    if k == M:
        if prime[total] and not check[total]:
            ret.append(total)
            check[total] = True
        return
    if s == N:
        return
    for i in range(s, N):
        combine(k+1, i+1, total + H[i])

ret = []
combine(0, 0, 0)
if ret:
    ret.sort() # 정렬을 안해주니 틀렸습니다 판정받았음
    print(*ret)
else:
    print(-1)
