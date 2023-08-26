# 합이 0 (3151번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))

cnt = 0
arr.sort()  # 정렬
for i in range(N - 2):
    s = i
    m = i + 1
    e = N - 1
    if arr[s] > 0:  # 제일 작은 숫자 값이 0보다 크면 0을 만들 수 없음
        break
    while m < e:
        _sum = arr[s] + arr[m] + arr[e]
        if _sum == 0:  # 세 수의 합이 0이면 같은 숫자가 있는지 확인해야 함
            l = 1
            r = 1
            if arr[m] == arr[e]:  # 두 수가 같으면 두 수 사이에 있는 경우의 쌍을 구함
                cnt += ((e - m + 1) * (e - m)) // 2
                break
            while m + 1 < e and arr[m + 1] == arr[m]:
                m += 1
                l += 1
            while m < e - 1 and arr[e - 1] == arr[e]:
                e -= 1
                r += 1
            cnt += l * r
        if _sum > 0:
            e -= 1
        else:
            m += 1

print(cnt)