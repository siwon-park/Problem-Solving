# 싸이버개강총회 (19583번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/19583
    # 문자열, 집합, 딕셔너리
    # 문자열의 파싱과 집합 또는 딕셔너리를 이용하는 문제이다.
    # 처음에 딕셔너리로 입출입을 체크했는데, 46%에서 틀렸습니다를 받았다.
    # 반례를 찾으려고 10분 간 고민했으나 도저히 못찾을 것 같아서 그만두고 집합으로 풀었다. 논리상 크게 차이가 없는 것 같은데 어디서 틀렸는지 모르겠다...
##############################################################################
import sys
input = sys.stdin.readline


def time_to_int(st):
    st = st.split(":")
    return int(st[0]) * 60 * 60 + int(st[1]) * 60


S, E, Q = input().rstrip().split()
S, E, Q = time_to_int(S), time_to_int(E), time_to_int(Q)
checked = set()
cnt = 0
while True:
    try:
        inp = input().rstrip().split()
        t = time_to_int(inp[0])
        name = inp[1]
        if t <= S:
            checked.add(name)
        elif E <= t <= Q and name in checked:
            cnt += 1
            checked.remove(name)
    except:
        break

print(cnt)
