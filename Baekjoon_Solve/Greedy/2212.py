# 센서(2212번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/2212
    # 그리디, 정렬
    # 행복 유치원(13164번)과 같은 문제이다.
    # 먼저 주어진 위치들을 정렬하고 서로 인접한 위치 간의 간격 차이를 계산하여 새로운 배열에 담는다.
    # 그리고 해당 배열을 역순으로 정렬하고 K-1번 인덱스부터 끝까지 더하면 된다
    # 역순 정렬하는 이유, K-1번 인덱스부터 끝까지 더하는 이유는
    # 최솟값을 구해야하므로 가장 큰 값들을 제외하기 위해서 역순 정렬하여 K - 1부터 끝까지 더하는 것이다.
    # 이때, K-1번 인덱스 전까지를 제외하는 이유는(K-1개의 큰 숫자를 제외하는 이유)
    # 예를 들어, 센서가 커버하는 영역을 K개의 집단으로 나눈다고 했을 때, 각 구간의 사이는 K-1개가 나온다
    # 즉, K-1개의 큰 숫자를 제외한다는 것은 해당 영역을 집단에 포함시키는 것이 아니라, 구간으로 둔다는 의미이다.
    # K-1개의 큰 숫자들은 각 구간의 간격(값)으로 두고 나머지는 K개의 집단으로 만드는 것이다.
##############################################################################################
import sys
input = sys.stdin.readline

N = int(input())
K = int(input())
lst = list(map(int, input().split()))
lst.sort()

arr = []
for i in range(1, N):
    arr.append(lst[i] - lst[i - 1])

arr.sort(reverse=True)
ans = sum(arr[K - 1:])

print(ans)
