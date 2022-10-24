# 암호 (1718번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/1718
    # 구현, 문자열
    # 복호화키의 값의 길이를 구한 다음 복호화 대상 문자열의 인덱스 % 길이를 인덱스로 하여
    # 옮길 칸 수를 구해서 복호화를 진행하면 된다.
###############################################################
import sys
input = sys.stdin.readline

S = input().rstrip()
encoder = input().rstrip()
N = len(S)
M = len(encoder)

ans = ""
for i in range(N):
    m = ord(encoder[i % M]) - 96
    s = S[i]
    c = ord(s) - m
    if s == " ":
        ans += s
    elif 97 <= c <= 122:
        ans += chr(c)
    elif c < 97:
        ans += chr(122 + c - 96)

print(ans)
