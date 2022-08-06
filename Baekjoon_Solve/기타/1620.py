# 나는야 포켓몬 마스터 이다솜(1620번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/1620
    # 맵(딕셔너리)
    # 딕셔너리에 포켓몬의 이름을 키로, 번호를 값으로 넣고 포켓몬의 번호(문자열)을 키로, 이름을 값으로 총 2번씩 넣으면 된다.
##################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
poke_dict = dict()

for i in range(N):
    poke_name = input().rstrip()
    poke_dict[str(i+1)] = poke_name
    poke_dict[poke_name] = i+1

for _ in range(M):
    query = input().rstrip()
    print(poke_dict[query])

