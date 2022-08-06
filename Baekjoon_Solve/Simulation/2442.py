# 별찍기-5(2442번)
#################################################
    # 문제: https://www.acmicpc.net/problem/2442
    # 구현
    # Python3 문자열 정렬에 대해 정리가 필요함(format 사용, 메서드 사용 등)
    # 그냥 print(s.center(2*N-1," "))을 하면 백준에서 출력형식이 잘못되었다고 나오는데, 뒤에 .rstrip()을 하니 해결되었다.
    # 질문게시판을 참고해서 알아봤는데 이렇게 정렬했을 경우 끝에 개행문자가 붙나보다.
#################################################
import sys
input = sys.stdin.readline

N = int(input())
for i in range(1, N+1):
    s = "*"*(2*i-1)
    print(s.center(2*N-1," ").rstrip())
