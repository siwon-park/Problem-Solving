# 멀티버스 I(18868번)
####################################################################################################
    # 문제: https://www.acmicpc.net/problem/18868
    # 브루트포스 알고리즘
    # 빠른 풀이들을 보니까 정렬을 하고 인덱스를 활용하던데, 왜 그러는 것인지 아이이디어에 대해 이해가 잘 안 간다.
    # 나는 그렇게 풀 생각을 하지도 못했고, 왜 정렬이 필요하고 .index를 사용하는 것인지 모르겠다
    # 나의 접근법은 처음에 i번째 우주의 행성 리스트를 입력 받을 때, 매번 빈 배열을 선언한 뒤에
    # # Ai < Aj 1을, Ai = Aj이면 2를, Ai > Aj이면 3을 방금 선언한 배열에 append한다
    # 그리고 나서 최종적으로 우주 배열에 append하여 O(M^2)의 시간으로 행성 간의 배열이 같으면 같은 쌍이므로
    # cnt += 1을 해주고 cnt를 출력한다
####################################################################################################
import sys
input = sys.stdin.readline

M, N = map(int, input().split())
univ = []
for _ in range(M):
    lst = list(map(int, input().split()))
    # Ai < Aj 1을, Ai = Aj이면 2를, Ai > Aj이면 3을 append
    planet = []
    for i in range(N - 1):
        for j in range(i+ 1, N):
            if lst[i] < lst[j]:
                planet.append(1)
            elif lst[i] == lst[j]:
                planet.append(2)
            elif lst[i] > lst[j]:
                planet.append(3)

    univ.append(planet)

# univ 안에 있는 배열이 일치하는 쌍을 찾음
cnt = 0 # 쌍의 개수
for i in range(M - 1):
    for j in range(i + 1, M):
        if univ[i] == univ[j]:
            cnt += 1

print(cnt)
