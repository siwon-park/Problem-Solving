# 파일 합치기3 (13975번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/13975
    # 그리디, 최소힙(우선순위 큐)
    # 이 문제는 문제에 나와있는 예제1에 대한 케이스를 설명하는 것에 매몰되면 접근을 잘못할 수도 있겠다는 느낌이 든다.
    # 300을 만드는 경우를 30 + 40 합치고, 30 +50 합치고, 만들어진 두 개를 합쳐서 300을 만드는데
    # 곰곰히 생각하니 이 방법 말고도 300을 만드는 방법이 있었다. 30 + 30, 40 + 50, 60 + 90 하여 300을 만들 수도 있다.
    # 보아하니 가장 작은 수 2개를 뽑아서 합치고 넣고를 반복하면 되는 것 같았다.
    # 즉, 최소힙으로 요소 2개를 뽑아서 합친 다음 큐에 넣고, 넣은 값을 정답에 누적하는 연산을 반복하면 된다.
############################################################################
import sys, heapq
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    K = int(input())
    files = list(map(int, input().split()))
    pq = []
    for i in range(K):
        heapq.heappush(pq, files[i])

    ans = 0
    while pq:
        min1 = heapq.heappop(pq)
        if pq:
            min2 = heapq.heappop(pq)
            ans += min1 + min2
            heapq.heappush(pq, min1 + min2)
    print(ans)
