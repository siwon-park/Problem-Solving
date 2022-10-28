# 블로그 (21921번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/21921
    # 슬라이딩 윈도우, 누적합
    # 누적합으로 풀어도 되고, 슬라이딩 윈도우로 풀어도 된다.
    # 구간의 합이 현재의 최댓값보다 크면 최대 일수는 다시 1부터 출발하고, 현재의 최댓값을 갱신한다.
    # 만약 구간의 합이 현재의 최댓값과 같다면 최대 일수를 1 증가시켜준다.
    # 제일 처음 출발하는 구간의 합이 전체 구간의 최댓값일 수도 있으니 최대 일수의 초깃값은 1에서부터 시작한다.(이 부분을 0에서 시작해서 처음에는 문제를 틀렸다.)
#############################################################################
import sys
input = sys.stdin.readline

N, X = map(int, input().split())
V = list(map(int, input().split()))

slide = sum(V[0:X])
max_slide = slide
cnt = 1
for i in range(X, N):
    slide += V[i]
    slide -= V[i - X]
    if slide > max_slide:
        cnt = 1
        max_slide = slide
    elif slide == max_slide:
        cnt += 1

if max_slide:
    print(max_slide)
    print(cnt)
else:
    print("SAD")
