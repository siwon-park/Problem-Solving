# 아이그루스와 화장실 (30642번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
mas = input().rstrip()
K = int(input().rstrip())

if mas == "annyong":
    if K % 2 == 0:
        if K + 1 <= N:
            print(K + 1)
        else:
            print(K - 1)
    else:
        print(K)
else:
    if K % 2 == 0:
        print(K)
    else:
        if K + 1 <= N:
            print(K + 1)
        else:
            print(K - 1)

