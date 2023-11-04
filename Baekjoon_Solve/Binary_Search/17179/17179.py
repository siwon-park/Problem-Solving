# 케이크 자르기 (17179번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/17179
    # 이분 탐색, 매개변수 탐색
    # 질문 게시판의 반례 덕분에 풀 수 있었다.
    # 곰곰이 생각해보니 틀린 풀이는 문제에서 주어진 L을 전혀 활용하지 못하는 상태였다.
    # 자르는 지점에 L을 추가하고, L인 지점에서도 자른다고 가정해야만 잘랐을 때 가장 작은 조각의 길이의 올바른 최댓값을 찾을 수 있다.
    # 따라서 자르는 횟수도 +1 추가한 값으로 고려해야 한다.
    # 예를 들어, 위와 같이 하지 않을 경우 자른 횟수와 잘린 조각의 수가 같다고 보게 된다.
    # 실제로 3번 자른다고 하면 잘린 조각의 수는 4개인데, 제일 마지막에 자른 조각의 길이를 고려하지 않게 된다.
###########################################################################
import sys
input = sys.stdin.readline

N, M, L = map(int, input().split())
cut_points = [int(input().rstrip()) for _ in range(M)] + [L]  # 제일 끝에서도 잘랐다고 가정해야 정확한 mid값을 계산 가능함
queries = [int(input().rstrip()) for _ in range(N)]

s, e = 1, 4 * int(1e6)


def binary_search(start, end, C):
    opt = 0
    while start <= end:
        mid = (start + end) // 2
        cut = 0  # 자른 횟수
        last = 0  # 자르는 지점
        for i in range(M + 1):
            if cut_points[i] - last >= mid:
                cut += 1
                last = cut_points[i]

        if cut > C:  # cut > C인 이유는 L인 지점에서 자르는 것을 포함해야 하기 때문
            opt = mid
            start = mid + 1
        else:
            end = mid - 1

    return opt


for n in range(N):
    cuts = queries[n]
    print(binary_search(s, e, cuts))
