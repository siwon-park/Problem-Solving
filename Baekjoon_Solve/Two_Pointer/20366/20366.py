# 같이 눈사람 만들래? (20366번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
H = list(map(int, input().rstrip().split()))
H.sort()  # 정렬
_min = H[N - 1] - H[0]


def solve(_min: int) -> int:
    min_diff = _min
    for i in range(N - 3):
        for j in range(i + 3, N):
            left = i + 1
            right = j - 1
            while left < right:
                diff = (H[i] + H[j]) - (H[left] + H[right])
                min_diff = min(min_diff, abs(diff))
                if diff > 0:
                    left += 1
                elif diff < 0:
                    right -= 1
                else:
                    return 0
    return min_diff


print(solve(_min))
