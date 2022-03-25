# 영재의 시험(19949번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/19949
    # 백트랙킹, 브루트포스 알고리즘
    # 선택할 수 있는 분기를 쉽게 설계할 수 있어서 풀 수 있었다.
    # 다 풀고나니 가지치기도 할 수 있을 것 같아서 적용했더니 체감상 더 빨라졌던 것 같다.
    # Python3으로 72ms에 푼 풀이를 보니까 메모이제이션을 적용한 풀이었다. 내 풀이는 448ms니까 거의 6배 이상은 차이가 난다.
    # 재귀 및 백트랙킹으로 메모이제이션을 원할하게 할 수 있을 때까지 연습해야겠다.
##########################################################################
import sys
input = sys.stdin.readline

def dfs(k, score, last, streak):
    global cnt
    # 가지치기(더 탐색해도 점수를 5점 이상 획득하지 못하는 경우)
    if 10 - k + score < 5:
        return
    if k == 10:
        if score >= 5:
            cnt += 1
        return
    # 5지선다에서 k번째 답을 고름
    for a in range(1, 6):
        # 답이 맞는 경우
        if a == ans[k]:
            # 두 개 연속까지는 고를 수 있다.
            if last == a and streak < 2:
                dfs(k+1, score+1, a, streak+1)
            elif last != a:
                dfs(k+1, score+1, a, 1)
        else: # 답이 틀린 경우
            if last == a and streak < 2:
                dfs(k+1, score, a, streak+1)
            elif last != a:
                dfs(k+1, score, a, 1)
ans = list(map(int, input().split()))
cnt = 0
dfs(0, 0, 0, 0)
print(cnt)
