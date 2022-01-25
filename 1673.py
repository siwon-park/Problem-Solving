# 치킨 쿠폰(1673번)
################################################
    # 문제: https://www.acmicpc.net/problem/1673
    # 수학, 구현
    # 단순 나눗셈 문제이지만 첫 시도에서 틀렸는데, 이유는 몫에 대해서만 생각했고, 나머지에 대해서 고려를 안 했다.
    # 나머지도 모여서 k개가 모이면 치킨을 시킬 수 있으므로, 나머지에 대해서도 감안했어야 했다.
    # 파이썬에서 EOF처리는 try, except 구문으로 해결 가능하다.
################################################
import sys
input=sys.stdin.readline
while True:
    try:
        n,k=map(int,input().split())
        total=n
        while n//k!=0:
            total+=n//k
            n=n//k+n%k
        print(total)
    except:
        break
