# 드래곤 앤 던전 (16434번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/16434
    # 구현, 이분탐색
    # 이분탐색 말고, 순수 구현으로도 풀 수 있는 문제
    # 이분탐색으로 풀었고, 처음에 틀렸습니다를 받았는데, 그 이유는 e의 범위를 작게 설정해서 그랬다. int(1e12)에서 sys.maxsize로 두니까 통과할 수 있었다.
    # 문제의 포인트는 (용사의 공격횟수 - 1) * 몬스터의 공격력만큼 매번 체력이 깎인다는 점이다.
    # 순수 구현 풀이법도 이점을 이용하는 것은 비슷한데, 차이가 있다면, 어차피 용사는 무조건 N번 방까지 갔을 때 살아남아 있어야 하므로
    # 주어진 몬스터들의 모든 공격을 다 받고나서 남아있는 체력이 더 크면 해당 체력이 바로 문제에서 원하고 있는 체력의 최솟값이다.
    # 즉, 용사가 입는 데미지를 계산해서 최종적으로 해당 데미지 + 1을 용사의 체력으로 결정하면 된다.
    # 구현 풀이법이 더 효율적일뿐더러, 아이디어도 좋다.
#####################################################################################
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
            if h - (atk_cnt) * cur_atk == 0:
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
########################## 순수 구현 풀이 #################################
import sys, math
input = sys.stdin.readline

N, Hatk = map(int, input().split())
max_hp = 0
cur_hp = 0  # 현재 체력

for i in range(N):
    t, a, h = map(int, input().split())  # 타입, 공격력, 체력
    if t == 1:  # 몬스터인 경우
        cur_hp -= math.ceil(h / Hatk - 1) * a  # (용사의 공격횟수 - 1) * 몬스터의 공격력만큼 체력 차감
    else:  # 물약인 경우
        Hatk += a
        cur_hp = min(cur_hp + h, 0)
    max_hp = max(max_hp, abs(cur_hp))  # cur_hp가 음수인 경우 절댓값 만큼의 체력이 필요
    
print(max_hp + 1)
