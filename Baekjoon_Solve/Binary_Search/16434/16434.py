import sys
input = sys.stdin.readline

N, Hatk = map(int, input().split())
s = 1
e = sys.maxsize
R = []
for _ in range(N):
    t, a, h = map(int, input().split())
    R.append((t, a, h))

Hmax = 0

while s <= e:
    mid = (s + e) // 2
    cur_hp = mid
    cur_atk = Hatk
    is_alive = True
    for i in range(N):
        t, a, h = R[i]
        if t == 2:  # 포션인 경우
            cur_atk += a
            cur_hp = mid if cur_hp + h >= mid else cur_hp + h
        else:
            atk_cnt = h // cur_atk  # 용사의 공격 횟수
            if h - (h // cur_atk) * cur_atk == 0:
                cur_hp -= (atk_cnt - 1) * a  # 용사의 공격 횟수 - 1 * 몬스터의 공격만큼 체력을 깎음
            else:
                cur_hp -= atk_cnt * a
            if cur_hp <= 0:
                is_alive = False
                break

    if is_alive:
        e = mid - 1
        Hmax = mid
    else:
        s = mid + 1

print(Hmax)