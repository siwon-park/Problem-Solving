# 계란으로 계란치기(16987번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/16987
    # 브루트포스, 백트랙킹
    # 문제의 두번째 조건 중 부가적으로 붙은 내용의 뜻이 이해가 잘 안돼서 문제를 설계하는 것보다 이해하는 데 시간이 더 걸렸던 것 같다.
    # "단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다."
    # 손에 든 계란이 깨졌다는 조건은 이해갔지만, 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다가 이해가 안 됐다.
    # 그래서 일단 완전히 이해는 되진 않았지만 설계를 끝내고 풀었고, 이해 안 됐던 조건은 사실상 else구문의 for구문 안에 if 구문이었다.
    # 내가 코드에 주석으로 적은 내용이 더 적절한 말인 것 같다. 내가 이해력이 부족한 것인지 왜 저걸 저렇게 표현했는지 조금 이해가 안 간다...
###############################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())

eggs = []
for _ in range(N):
    egg = list(map(int, input().split()))
    eggs.append(egg)

max_cnt = 0

def dfs(s, cnt):
    global max_cnt
    max_cnt = max(max_cnt, cnt)
    if s == N:
        return
    d, w = eggs[s] # 현재 계란을 pick
    if d <= 0: # pick한 계란의 내구도가 0이면 다음 계란을 든다
        dfs(s+1, cnt)
    else:
        for i in range(N):
            # 현재 계란이 아니면서 내구도가 0 이상인 계란이 있으면 친다
            if s != i and eggs[i][0] > 0:
                eggs[i][0] -= w # 치는 계란의 무게만큼 상대방 계란의 내구도 감소
                eggs[s][0] -= eggs[i][1]  # 치는 계란의 내구도는 상대방 계란의 무게만큼 감소
                cur_cnt = cnt # 현재 깨진 계란의 수
                if eggs[i][0] <= 0:
                    cnt += 1
                if eggs[s][0] <= 0:
                    cnt += 1
                dfs(s+1, cnt) # 현재 든 계란의 오른쪽 계란을 든다
                eggs[s][0] += eggs[i][1]
                eggs[i][0] += w
                cnt = cur_cnt # 깨진 계란의 수 현재 상태로 원상복구
dfs(0, 0)
print(max_cnt)
