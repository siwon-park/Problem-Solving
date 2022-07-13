# 행복 유치원(13164번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/13164
    # 그리디
    # 골드 5문제이지만, 접근 방법이 조금 어려운 편인 것 같다
    # 바로 인접한 유치원생과의 차이를 구한 다음 내림차순 정렬하고 K-1개를 뺀 개수만큼 더한다
    # K-1개인 이유는 K개의 조로 나누려면 K-1개의 선을 그어야하기 때문이다.
#########################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

lst = []
for i in range(1, N):
    lst.append(arr[i] - arr[i - 1])

lst.sort(reverse=True)

print(sum(lst[K-1:]))
