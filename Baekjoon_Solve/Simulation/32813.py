import sys
input = sys.stdin.readline

# Oooh I See (32813번)
r, c = map(int, input().rstrip().split())
cnt = 0
_d = [-1, 0, 1]
graph = []
for i in range(r):
    graph.append(input().rstrip())

ans_y, ans_x = 0, 0
for y in range(r):
    for x in range(c):
        if graph[y][x] == '0':
            flag = True
            for dy in _d:
                for dx in _d:
                    ny = y + dy
                    nx = x + dx
                    if y == ny and x == nx:
                        continue
                    if ny < 0 or ny >= r or nx < 0 or nx >= c:
                        flag = False
                    else:
                        if graph[ny][nx] == '0':
                            flag = False
            if flag:
                cnt += 1
                ans_y, ans_x = y, x

if cnt == 1:
    print(ans_y + 1, ans_x + 1)
elif cnt > 1:
    print(f"Oh no! {cnt} locations")
else:
    print("Oh no!")

