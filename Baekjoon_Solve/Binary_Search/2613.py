# 숫자 구슬 (2613번)
#############################################################################################
    # 문제: https://www.acmicpc.net/problem/2613
    # 이분 탐색
    # 문제를 보자마자 이분탐색 문제임을 알았고, 이분탐색으로 접근하였다.
    # 구슬 그룹의 합의 최댓값의 최솟값을 찾는데에는 어려움이 없었다.
    # 문제는 그룹의 구슬수를 출력하는 것이었는데, 중요한 것은 각 그룹의 구슬 수는 최소 1개이다.
    # 여러 번 틀렸습니다를 받았는데, 전부 다 잘못된 그룹의 구슬수를 출력하고 있었다.
    # 핵심은 구한 그룹들에 대해서 그룹의 구슬 수가 1 이상인 경우에 대하여 구슬수를 절반으로 쪼개는 것이다.
    # 어차피 지금 나온 경우의 수로 최댓값이 최소인 경우를 만들 수 있으므로, 만약 그룹에 있는 구슬을 나눌 경우 최댓값이 더 작아질 수 있지도 않을까 싶지만
    # 그렇게 된다면 애초에 이분탐색 과정에서 더 작은 최댓값을 가지는 경우의 수를 만들 수 있으므로 그런 경우는 나올 수 없다.
    # 따라서 구슬을 절반씩 쪼개다가 그룹 수가 M이 되는 순간 break를 하여 빠져나오면 된다.
    # 이렇게 구슬 수를 절반으로 쪼개는 방식으로 접근했음에도 틀렸다는 판정을 받았는데, 알고보니 그룹의 수가 M이 될 때까지 반복했어야 했는데,
    # 반복문을 1번만 돌려주고 있었다. while구문과 pop(i), insert(i)를 활용하여 문제를 해결할 수 있었다.
    # 풀고나니 생각보다 풀이 속도가 빨라서 의외였다.
    # 어쩌면 스페셜 저지 문제를 잘 푸는 것도 알고리즘 스킬을 향상시키는데 도움이 될지 모르겠다는 생각이 들었다.
    # 왜냐하면 최댓값의 최소는 빨리 찾았는데, 경우의 수를 구하는데 어려움을 느꼈기 때문에 문제를 완벽하게 잘 풀지 못했다는 생각이 들어서이다.
#############################################################################################
import sys, math
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
lst = list(map(int, input().split()))
total = sum(lst)


def binary_search():
    opt_lst = []
    opt_sum = 0
    s, e = min(lst), total  # 이분탐색의 범위는 합임
    while s <= e:
        mid = (s + e) // 2
        bid_sum = 0
        groups = 1  # 그룹의 수
        cnt = 0  # 그룹 안의 구슬 수
        tmp_lst = []
        for i in range(N):
            if bid_sum + lst[i] > mid:  # 그룹의 합이 mid보다 커지면
                groups += 1  # 그룹의 수를 증가시킴
                tmp_lst.append(cnt)  # 그룹 내의 구슬을 리스트에 추가
                cnt = 1
                bid_sum = lst[i]
            else:
                bid_sum += lst[i]
                cnt += 1
        if cnt:
            tmp_lst.append(cnt)
        if groups <= M and max(lst) <= mid:
            e = mid - 1
            opt_sum = mid
            opt_lst = tmp_lst[:]
        else:
            s = mid + 1
    return opt_sum, opt_lst


ans = binary_search()
print(ans[0])
balls = ans[1]
while len(balls) < M:  # 공의 그룹 수가 M보다 작을 경우 공을 쪼갬
    for i in range(len(balls)):
        if balls[i] > 1:
            ball = balls[i]
            balls.pop(i)
            balls.insert(i, math.ceil(ball / 2))
            balls.insert(i, math.floor(ball / 2))
            if len(balls) == M:
                break

print(*balls)
