# 비밀번호 발음하기 (4659번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/4659
    # 구현, 문자열
    # 주어진 조건에 맞게 문제를 구현하면 된다.
####################################################################################
import sys
input = sys.stdin.readline

while True:
    pw = input().rstrip()
    if pw == "end":
        break
    streak1, streak2, streak3 = 0, 0, 0 # 모음 연속, 자음 연속, 같은 글자 연속
    aeiou = False
    aeious = {"a", "e", "i", "o", "u"}
    acceptable = True
    n = len(pw)
    last = "" # 마지막 문자
    for i in range(n):
        s = pw[i]
        if s in aeious:
            aeiou = True
            if last not in aeious:
                streak1 = 0
            streak1 += 1
        else:
            if last in aeious:
                streak2 = 0
            streak2 += 1
        if last == s and s != "e" and s != "o":
            streak3 += 1
        else:
            streak3 = 1
        if streak1 == 3 or streak2 == 3 or streak3 == 2:
            acceptable = False
            break
        last = s
    # 모음을 하나도 포함하지 않을 경우 False
    if not aeiou:
        acceptable = False

    if acceptable:
        print(f'<{pw}> is acceptable.')
    else:
        print(f'<{pw}> is not acceptable.')
