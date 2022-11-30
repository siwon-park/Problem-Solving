# 한국이 그리울 땐 서버에 접속하지 (9996번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/9996
    # 문자열
    # 예외 케이스가 있어서 찾는데 오래 걸렸다.
    # *이 중간에 있을 경우, 접두사와 접미사를 고려해서 검사했을 때 문자열에서 체크한 부분이 중복되면 안 된다.
    # 예) abc*cdef, abcdef인 경우 abc를 접두사로 고려했으니 def를 고려해야하는데, 단순히 endswith(cdef)를 하면 True이므로
    # 패턴이 매칭되지 않는데 정답이 아니다.
###################################################################################
import sys
input = sys.stdin.readline


def check(p, s):
    n = len(p)
    m = len(s)
    if p[n - 1] == "*":
        p = p[:n - 1]
        if s.startswith(p):
            return "DA"
        else:
            return "NE"
    elif p[0] == "*":
        p = p[1:]
        if s.endswith(p):
            return "DA"
        else:
            return "NE"
    else:
        p = p.split("*")
        if not s.startswith(p[0]):
            return "NE"
        elif not s[len(p[0]):].endswith(p[1]):
            return "NE"
        return "DA"


N = int(input().rstrip())
P = input().rstrip()
for _ in range(N):
    S = input().rstrip()
    print(check(P, S))
