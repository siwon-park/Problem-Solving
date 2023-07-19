# 지뢰찾기 (9082번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for t in range(T):
    N = int(input().rstrip())
    cnt = 0  # 지뢰의 개수
    nums = list(map(int, list(input().rstrip())))
    mines = list(input().rstrip())
    if N == 1 and nums[0] != 0:  # N의 길이가 1이고, 지뢰가 설치되어 있는 경우
        cnt += 1
    elif N >= 2:
        if nums[0] != 0 and nums[1] != 0:  # 1열, 2열에 숫자가 0보다 큰 경우
            # 1열이나 2열에 지뢰를 심은 것으로 하고 숫자를 감소하고 지뢰 수를 증가
            cnt += 1
            nums[0] -= 1
            nums[1] -= 1
        if nums[N - 2] != 0 and nums[N - 1] != 0:  # 마지막 열, 마지막 이전 열에 대해서 동일한 처리
            cnt += 1
            nums[N - 2] -= 1
            nums[N - 1] -= 1
        # 접한 3개의 열에 대해서 지뢰를 심어봄
        for i in range(1, N - 1):
            if i + 1 < N and nums[i - 1] != 0 and nums[i] != 0 and nums[i + 1] != 0:
                cnt += 1
                nums[i - 1] -= 1
                nums[i] -= 1
                nums[i + 1] -= 1

    print(cnt)
