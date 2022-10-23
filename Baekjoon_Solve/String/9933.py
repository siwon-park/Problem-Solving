# 민균이의 비밀번호(9933번)
#################################################################################
    # 문제: https://www.acmicpc.net/problem/9933
    # 문자열
    # 회문일 경우 무조건 비밀번호가 될 수 있는 모든 조건을 만족하므로 비밀번호이다. 따라서 그대로 문자열의 길이와 가운데 글자를 출력하면 된다.
    # 그게 아닐 경우라면, 본래의 문자열이 문자열 리스트에 있는지와 역순 문자열이 문자열 리스트에 있는지 확인해서
    # 둘 다 있을 경우 해당 문자열의 길이와 중간 글자를 출력하면 된다.
#################################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = [input().rstrip() for _ in range(N)]

for i in range(N):
    s = lst[i]
    rs = s[::-1]
    l = len(s)
    is_pw1 = False
    is_pw2 = False
    if s == rs:
        print(l, s[l // 2])
        break
    else:
        for j in range(N):
            if s in lst[j]:
                is_pw1 = True
            if rs in lst[j]:
                is_pw2 = True
        if is_pw1 and is_pw2:
            print(l, s[l // 2])
            break
