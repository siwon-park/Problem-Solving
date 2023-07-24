# 포켓몬 GO (13717번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
best_pokemon = ""
best_cnt = 0
ans = 0
for _ in range(N):
    pokemon = input().rstrip()
    need, candy = map(int, input().rstrip().split())
    cur_cnt = 0  # 현재 진화 가능 수
    quot = candy // need  # 몫
    while quot > 0:
        cur_cnt += quot
        r = candy % need  # 나머지
        candy = r + quot * 2
        quot = candy // need

    ans += cur_cnt

    if best_cnt < cur_cnt:
        best_cnt = cur_cnt
        best_pokemon = pokemon

print(ans)
print(best_pokemon)