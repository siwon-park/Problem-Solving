import sys

input = sys.stdin.readline

# 이름 궁합 (15312번)
A = input().rstrip()
B = input().rstrip()
_dict = {"A": 3, "B": 2, "C": 1, "D": 2, "E": 3, "F": 3, "G": 2, "H": 3, "I": 3, "J": 2, "K": 2, "L": 1, "M": 2,
         "N": 2, "O": 1, "P": 2, "Q": 2, "R": 2, "S": 1, "T": 2, "U": 1, "V": 1, "W": 1, "X": 2, "Y": 2, "Z": 1}
lst = []
l = 0
for i in range(len(A)):
    lst.append(_dict.get(A[i]))
    lst.append(_dict.get(B[i]))
    l += 2

nxt = []
while l > 2:
    for i in range(1, l):
        nxt.append((lst[i - 1] + lst[i]) % 10)
    lst = nxt
    nxt = []
    l -= 1

print(str(lst[0]) + str(lst[1]))

