# 부분 문자열 (6550번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/6550
    # 문자열, 그리디
    # N*M 비교를 해주면 O(N*M)으로 시간초과가 나니까,
    # t의 앞에서부터 시작해서 n = 0부터 s의 길이 - 1까지 보았을 때, s와 일치하는 문자열이 있으면 n을 1 증가시켜주면서
    # n이 s의 길이와 일치한다면 t의 부분문자열로 s가 있는 것이므로 break하여 Yes를 출력하고, while문을 다 돌고 나서도 없으면 No를 출력하면 된다.
##################################################################################
import sys
input = sys.stdin.readline

while True:
    try:
        s, t = input().rstrip().split()
        N, M = len(s), len(t)
        n, m = 0, 0
        flag = False
        while m < M:
            if t[m] == s[n]:
                n += 1
                if n == N:
                    flag = True
                    break
            m += 1
        if flag:
            print("Yes")
        else:
            print("No")
    except:
        break
