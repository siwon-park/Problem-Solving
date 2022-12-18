# 가희와 3단 고음(16162번)
"""
    문제: https://www.acmicpc.net/problem/16162
    그리디
    역시 문제를 제대로 읽는 게 많이 중요하다. 잠깐 봤을 때는 어려울 수도 있겠는데라는 생각이 들었는데,
    예제를 보면서 문제를 천천히 읽어보니 엄청 쉬운 문제라는 것을 알았다.
    반복문을 돌리면서 고음의 첫항(A)으로 시작할 수 있는 수, 즉 A와 같은 수를 찾는다.
    찾았으면 고음의 단수(x)를 1증가시켜주고, A에 공차인 D를 더한다.
    반복문을 돌면서 A와 같은 수를 찾으면 위와 같은 과정을 반복해준다.
"""
import sys
input = sys.stdin.readline

N, A, D = map(int, input().split())
lst = list(map(int, input().split()))

x = 0
for i in range(N):
    if lst[i] == A:  # 가능한 고음이면 단수를 증가
        x += 1
        A += D

print(x)
