# K번째 수 (1300번)
#################################################################################
    # 문제: https://www.acmicpc.net/problem/1300
    # 이분탐색
    # N이 최대 10^5라서 2차원의 배열을 다 만들고 정렬할 수가 없다.
    # 따라서 이분탐색을 통해 mid보다 큰 값이 K개 이상을 만족하는 가장 작은 mid를 찾으면 그 mid가 K번째 수이다.
    # 즉, mid - 1이하의 수는 K개 미만이고, mid 이하의 수가 K개 이상이면 mid가 K번째 수가 되는 것이다.
    # 처음에 2중 for문을 통해 i*j를 계산하여 이 값이 mid보다 크면 break하여 mid 이하의 수의 개수를 구했는데, 시간초과가 났다.
    # 하지만 이렇게 2중 for문을 돌릴 필요 없이, 간단하게 i번째 행에서 mid보다 작은 수의 개수를 구할 수 있었는데,
    # 결국 우리가 찾고자 하는 것은 i번째 행에서 mid보다 작은 수의 "개수"이다.
    # 이를 잘 생각해보면, mid를 i로 나눈 몫이 바로 i번째 행에서 mid 이하의 수의 개수가 된다.
    # 예를 들어 5X5 행렬에서 2번째 행은 2 4 6 8 10인데, 이 때 mid가 7이라면 7 // 2 = 3으로 7보다 작은 수는 2 4 6으로 3개이다.
    # 만약 mid // i가 N보다 크면? i X N < mid 인 값은 NxN 행렬상에서 존재하지 않으므로, mid // i가 N보다 크면 mid 이하의 수는 N개이다.
    # 이런식으로 빠르게 mid 이하의 수를 계산하여 mid 이하의 수가 K개 이상인 최소 mid 값을 찾으면 된다.
#################################################################################
import sys
input = sys.stdin.readline


def binary_search(n, k):
    num = 0
    s, e = 1, n * n
    while s <= e:
        mid = (s + e) // 2
        cnt = 0
        for i in range(1, N + 1):
            cnt += min(mid // i, n)
        if cnt >= k:
            e = mid - 1
            num = mid
        else:
            s = mid + 1

    return num


N = int(input().rstrip())
K = int(input().rstrip())

print(binary_search(N, K))
