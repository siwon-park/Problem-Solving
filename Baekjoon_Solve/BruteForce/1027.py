# 고층 건물(1027번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/1027
    # 브루트포스 알고리즘, CCW
    # 기울기를 활용한 브루트포스 완전탐색 문제인줄 알았는데, 테스트 케이스를 직접 돌려보면서 생각해보니
    # 단순히 기울기만으로는 풀 수 없는 문제였다.
    # 그래서 질문 게시판을 보니 CCW라는 말이 나오길래 검색해보고 이해를 해서 문제를 풀 수 있었다.(관련 개념은 따로 정리)
    # CCW(CounterClockWise)는 선분 교차를 판단할 때 사용할 수 있는 개념이다.
    # 좌표 평면 상의 세 점을 대상으로 CCW의 결과가 양수이면 반시계 방향, 0이면 평행, 음수이면 시계 방향이라고 판단할 수 있다.
    # 이 문제에서 CCW의 적용은 현재 좌표를 기준으로 좌측을 탐색한다 했을 때, 어떤 목표 빌딩과 그 사이에 있는 빌딩을 대상으로 CCW를 계산한다
    # 만약 0이면 평행이므로 문제 조건에 해당하지 않아서 카운트를 하지 않는다. 또한 사이에 있는 빌딩이 목표 빌딩이나 현재 빌딩보다 높다면
    # 현재 위치를 기준으로 그 선을 순서대로 이었을 때, 반시계방향이 된다. 따라서 CCW가 양수이면 카운트를 해서는 안된다.
    # 역으로 오른쪽 탐색을 한다했을 때는, 0과 시계방향(음수)일 때는 카운트해서는 안 된다.
    # 오랜만에 새로운 개념을 배울 수 있었다. 많이 나오는 개념은 아니겠지만 앞으로 쓸 수도 있으니 따로 정리해둬야겠다.
##########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))

def CCW(x1, x2, x3, y1, y2, y3):
    return (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)

max_cnt = -sys.maxsize
for i in range(N):
    cur = lst[i]
    cnt = 0
    # 왼쪽 탐색
    for j in range(i):
        target = lst[j]
        flag = True
        # i와 j 사이에 있는 건물들을 탐색
        for k in range(j + 1, i):
            deg = CCW(i, k, j, cur, lst[k], target) # CCW의 결과가 평행(0)이거나 반시계(양수)이면 break
            if deg >= 0:
                flag = False
                break
        if flag:
            cnt += 1
    # 오른쪽 탐색
    for j in range(i+1, N):
        target = lst[j]
        flag = True
        # i와 j 사이에 있는 건물들을 탐색
        for k in range(i + 1, j):
            deg = CCW(i, k, j, cur, lst[k], target) # CCW의 결과가 평행(0)이거나 시계(음수)이면 break
            if deg <= 0:
                flag = False
                break
        if flag:
            cnt += 1
    max_cnt = max(max_cnt, cnt)

print(max_cnt)
