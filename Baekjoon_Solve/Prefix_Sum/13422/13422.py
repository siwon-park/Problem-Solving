# 도둑 (13422번)
import sys
input = sys.stdin.readline

TC = int(input().rstrip())
for tc in range(TC):
    ans = 0
    N, M, K = map(int, input().rstrip().split())  # 마을, 연속된 집의 수, 상한선
    arr = [0] + list(map(int, input().rstrip().split()))
    if N == M:  # N과 M이 같을 경우 -> 어느 지점에서 잡아도 원형이기 때문에 누적합만 고려
        for i in range(1, N + 1):
            arr[i] += arr[i - 1]
        if arr[N] - arr[0] < K:
            ans += 1
    else:
        # 원형이기 때문에 arr의 맨 앞의 M - 1개를 뒤에 추가적으로 붙임
        for i in range(1, M):
            arr.append(arr[i])
        # 누적합 계산
        for i in range(1, N + M):
            arr[i] += arr[i - 1]
        # 투 포인터 실행
        s, e = 0, M
        while s < e and e < N + M:
            if arr[e] - arr[s] < K:  # M개의 연속된 집에서 K 미만으로 훔칠 수 있으면
                ans += 1
            s += 1
            e += 1
    print(ans)
