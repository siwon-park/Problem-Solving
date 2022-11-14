# 도비의 난독증 테스트 (2204번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/2204
    # 문자열, 정렬
    # 빈 배열에 원본 문자열과 원본 문자열을 모두 소문자로 바꾼 문자열을 함께 넣은 다음에
    # 모두 소문자인 문자열을 기준으로 정렬하여, 제일 처음 인덱스의 원본 문자열을 출력하면 된다.
######################################################################################
import sys
input = sys.stdin.readline

while True:
    n = int(input().rstrip())
    if not n:
        break
    lst = []
    for _ in range(n):
        S = input().rstrip()
        T = ""
        for s in S:
            T += s.lower()
        lst.append((T, S))

    lst.sort(key=lambda x: x[0])

    print(lst[0][1])
