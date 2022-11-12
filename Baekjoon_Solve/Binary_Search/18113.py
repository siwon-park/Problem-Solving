# 그르다 김가놈 (18113번)
#####################################################################
    # 문제: https://www.acmicpc.net/problem/18113
    # 이분탐색
    # 우선 주어진 김밥을 먼저 문제 조건에 따라 정리해준 다음에 이분 탐색을 실시하면 된다.
    # Python3로는 통과한 사람이 없어서 Pypy3로 제출했다. valueError가 나서 봤더니, if-else 구문에 따라 arr가 결정되는데
    # arr가 빈 배열일 경우 max(arr)를 사용할 수 없으므로 발생하는 에러였다. 주어지는 모든 값이 1일 때 그랬다.
    # 그래서 e의 값을 arr가 있을 경우에만 max(arr)로 설정하였다.
#####################################################################
import sys
input = sys.stdin.readline

N, K, M = map(int, input().split())  # 김밥의 수, 꼬다리, 최소 갯수
P = -1  # 김밥 조각의 최소 갯수
arr = []

for _ in range(N):
    gimbab = int(input().rstrip())
    if gimbab <= K:  # 김밥 길이가 K보다 짧거나 같으면 폐기
        continue
    elif gimbab < 2 * K:
        gimbab -= K
        arr.append(gimbab)
    else:
        gimbab -= 2 * K
        arr.append(gimbab)

n = len(arr)

s, e = 1, max(arr) if n else 0
while s <= e:
    mid = (s + e) // 2
    cnt = 0  # 김밥의 수
    for i in range(n):
        cnt += arr[i] // mid

    if cnt >= M:
        s = mid + 1
        P = mid
    else:
        e = mid - 1

print(P)
