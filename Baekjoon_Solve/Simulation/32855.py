# Which One is Larger (32855번)
import sys
input = sys.stdin.readline

A = input().rstrip()
B = input().rstrip()

dec_A = float(A)
dec_B = float(B)

tuple_A = tuple(map(int, A.split(".")))
tuple_B = tuple(map(int, B.split(".")))

if dec_A > dec_B and tuple_A[0] >= tuple_B[0]:
    if tuple_A[0] > tuple_B[0]:
        print(A)
    elif tuple_A[0] == tuple_B[0] and tuple_A[1] > tuple_B[1]:
        print(A)
    else:
        print(-1)
elif dec_A < dec_B and tuple_A[0] <= tuple_B[0]:
    if tuple_A[0] < tuple_B[0]:
        print(B)
    elif tuple_A[0] == tuple_B[0] and tuple_A[1] < tuple_B[1]:
        print(B)
    else:
        print(-1)
else:
    print(-1)

