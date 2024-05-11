# 내 학점을 구해줘 (10984번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for t in range(T):
    N = int(input().rstrip())
    total_c = 0
    gpa = 0
    for i in range(N):
        C, G = map(float, input().rstrip().split())
        total_c += int(C)
        gpa += C * G
    print(total_c, f'{(gpa / total_c):.1f}')

