# 우체국(2141번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/2141
    # 그리디, 정렬
    # 마을 위치를 기준으로 정렬하고 나서, 인구수 누적의 절반 이상이 되는 구간에 우체국을 설치한다
    # 왜 수학적으로 이렇게 되는지 잘 모르겠다... 힌트가 없었으면 못 풀었을 것이다. 사실 그렇게 따지니 이 문제는 내가 푼 문제가 아니다... ㅠㅜ
#############################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = []
total = 0
for _ in range(N):
    X, A = map(int, input().split())
    total += A
    lst.append((X, A))

lst.sort(key=lambda x: x[0])

total /= 2 # 인구수 누적의 절반 //= 2를 쓰니 100%에서 틀렸습니다를 계속 받았음

prefix_sum = 0
for i in range(N):
    x, a = lst[i]
    prefix_sum += a
    if prefix_sum >= total: # 인구수 누적의 절반 이상 큰 곳에서 우체국을 설치함
        ans = x
        break

print(ans)
