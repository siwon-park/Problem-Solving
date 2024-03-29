# 신입 사원(1946번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/1946
    # 그리디, 정렬
    # 어느 순으로 정렬하든 맨 앞의 요소는 항상 뽑힌다.
    # 그 다음으로 뽑히는 사람은 일단 정렬 기준 요소로는 순위가 낮지만, 정렬 기준 요소가 아닌 것의 순위가 더 높으면 된다.
    # 다만, 이제껏 등장한 사람 중 절대적으로 모든 요소의 성적이 높은 사람이 있다면, 뽑으면 안 된다.
    # 따라서 정렬 기준 요소가 아닌 것의 최소를 갱신하면서 해당 값보다 낮은 값이 나올 경우에만 cnt += 1을 해준다.
    # 왜냐하면 정렬 기준 요소로는 현재 요소는 앞의 요소보다 항상 순위가 낮을 수 밖에 없지만, 정렬 기준 요소가 아닌 것의 요소의 성적이 높으면 뽑히기 때문
    # 정렬 기준 요소가 아닌 것의 최소는 절대적으로 성적이 낮은 사람을 배제하기 위함이다.
##############################################################################
import sys
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    N = int(input())
    lst = []
    for i in range(N):
        p_score, i_score = map(int, input().split()) # 서류 성적, 인터뷰 성적
        lst.append((p_score, i_score))

    lst.sort(key=lambda x: x[0]) # 성적순 정렬
    picked = lst[0] # 뽑힌 사람(어느 순으로 정렬하든 첫 요소는 항상 뽑힘)
    min_score = picked[1]
    cnt = 1
    for i in range(1, N):
        if lst[i][1] < min_score:
            cnt += 1
            min_score = lst[i][1]

    print(cnt)
