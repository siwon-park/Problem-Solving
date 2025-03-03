import sys
input = sys.stdin.readline

# 스텔라(STELLA)가 치킨을 선물했어요 (15905번)
n = int(input().rstrip())
lst = []
for i in range(n):
    sol, pen = map(int, input().rstrip().split())
    lst.append((sol, pen))

lst.sort(key=lambda x: (-x[0], x[1]))

ans = 0
if n <= 5:  # 5명 이하면 5등까지밖에 없음
    print(ans)
else:
    sol_5th = lst[4][0]  # 5등이 푼 개수
    for i in range(5, n):
        if lst[i][0] == sol_5th:
            ans += 1
    print(ans)

