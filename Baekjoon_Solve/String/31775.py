# 글로벌 포닉스 (31775번)
import sys
input = sys.stdin.readline

S1 = input().rstrip()
S2 = input().rstrip()
S3 = input().rstrip()

lst = [S1[0], S2[0], S3[0]]
lst.sort()

if "".join(lst) == 'klp':
    print('GLOBAL')
else:
    print('PONIX')

