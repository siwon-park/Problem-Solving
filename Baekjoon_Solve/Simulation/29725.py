# 체스 초보 브실이 (29725번)
import sys
input = sys.stdin.readline

w_dict = {"P": 1, "N": 3, "B": 3, "R": 5, "Q": 9}
b_dict = {"p": 1, "n": 3, "b": 3, "r": 5, "q": 9}

W, B = 0, 0
for i in range(8):
    line = input().rstrip()
    for j in range(8):
        if line[j] in w_dict:
            W += w_dict.get(line[j])
        elif line[j] in b_dict:
            B += b_dict.get(line[j])

print(W - B)
