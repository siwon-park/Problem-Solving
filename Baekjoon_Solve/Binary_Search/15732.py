# 도토리 숨기기 (15732번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/15732
    # 이분탐색
    # K번째 수와 비슷한 로직의 문제
    # mid 이하의 상자의 개수가 D 이상을 만드는 mid의 최솟값을 찾으면 된다.
    # 단, K번째 수 문제와 차이가 있다면, 시작 상자의 번호와 끝 상자의 번호, 상자 간 건너뛰는 숫자가 있지만 내용 자체는 유사하다.
    # (mid - 시작 상자 번호) // 건너뛰는 수에 1을 더한 값이 해당 구간에서 mid 이하의 상자의 개수이다. 1을 더하는 이유는 시작 상자를 포함하기 위함이다.
    # 해당 구간의 상자 개수는 역시 같은 공식으로, (끝 상자 - 시작 상자) // 건너뛰는 수에 + 1을 더한 값이다.
    # 둘 중 작은 값을 cnt에 누적하여 cnt가 D 이상인 경우에 mid 값을 줄여서 탐색하면 된다.
    # 중요한 것은 여기서 실수하지 말아야할게 mid값이 만약 a보다 작다면 해당 구간의 상자를 계산했을 때 음수가 나올 수도 있으므로 cnt에 음수가 합산되지 않도록
    # mid < a인 경우에 continue를 하여 해당 경우에 대해 체크해주면서 넘어가면 된다.
###########################################################################################
import sys
input = sys.stdin.readline

N, K, D = map(int, input().split())
lst = []
max_b = 0
min_a = int(1e7)
for _ in range(K):
    A, B, C = map(int, input().split())
    lst.append((A, B, C))   # A ~ B까지 C개씩 넣는다
    max_b = max(max_b, B)
    min_a = min(min_a, A)


def binary_search(_min, _max, k, _list):
    s, e = _min, _max
    last = _min
    while s <= e:
        mid = (s + e) // 2  # 상자 번호
        cnt = 0  # 도토리를 넣은 개수

        for i in range(k):
            a, b, c = _list[i]
            if mid < a:  # a보다 작은 경우에 대해서 체크
                continue
            p1, p2 = (mid - a) // c, (b - a) // c
            cnt += min(p1 + 1, p2 + 1)
        if cnt >= D:
            e = mid - 1
            last = mid
        else:
            s = mid + 1
    return last


print(binary_search(min_a, max_b, K, lst))
