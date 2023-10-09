# 사과 담기 게임 (2828번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
J = int(input().rstrip())
apple_pos = [int(input().rstrip()) for _ in range(J)]

s = 1
e = M
move = 0
for i in range(J):
    pos = apple_pos[i]
    if s <= pos <= e:  # 바구니 범위에 포함되면 움직일 필요 없음
        continue
    else:  # 바구니를 옮겨야 함
        if pos < s:
            move += s - pos
            s = pos
            e = pos + M - 1
        else:
            move += pos - e
            s = pos - M + 1
            e = pos

print(move)
