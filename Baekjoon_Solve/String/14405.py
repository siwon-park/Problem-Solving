# 피카츄 (14405번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/14405
    # 문자열
    # replace로 풀었다가 틀린 결과를 받았다
    # kpia의 경우 replace를 사용하면 문제 조건에 따랐을 때 읽지 못하는 문자임에도 불구하고, 읽을 수 있다고 간주하기 때문이다.
    # 따라서 직접 반복문을 돌려서 검사하는 방식으로 해결하였다.
##########################################################################
import sys
input = sys.stdin.readline

S = input().rstrip()


def check(word):
    N = len(word)
    l = 0
    cur = ""
    ret = ""
    for i in range(N):
        cur += word[i]
        l += 1
        if l == 2 and (cur == "pi" or cur == "ka"):
            l = 0
            ret += cur
            cur = ""
        if l == 3 and cur == "chu":
            l = 0
            ret += cur
            cur = ""

    if ret == word:
        return "YES"
    return "NO"


print(check(S))
