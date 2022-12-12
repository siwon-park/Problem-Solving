# ZOAC 3 (20436번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/20436
    # 문자열, 구현
    # "한글 자음 쪽 자판은 왼손 검지손가락으로 입력하고, 한글 모음 쪽 자판은 오른손 검지손가락으로 입력한다"는 조건만 유의하면
    # 나머지는 문제에서 주어진대로 구현만 하면 통과할 수 있다.
    # 처음에 딕셔너리 구성에 대해서 하드 코딩을 할 뻔했는데, 리스트로 만든 다음에 반복문을 돌려서 간단하게 만들 수 있었다. 
########################################################################################
import sys
input = sys.stdin.readline


def cal_dist(y1, x1, y2, x2):
    return abs(y1 - y2) + abs(x1 - x2)


lst = ["qwertyuiop", "asdfghjkl", "zxcvbnm"]
key_dict = dict()
for i in range(3):
    for j in range(len(lst[i])):
        key_dict[lst[i][j]] = (i, j)

left_press = {"q", "w", "e", "r", "t", "a", "s", "d", "f", "g", "z", "x", "c", "v"}

sl, sr = input().rstrip().split()
S = input().rstrip()
t = 0
cur_left, cur_right = key_dict[sl], key_dict[sr]
for s in S:
    ty, tx = key_dict[s]
    if s in left_press:  # 왼쪽 손으로 누름
        ly, lx = cur_left
        t += cal_dist(ly, lx, ty, tx) + 1
        cur_left = key_dict[s]
    else:  # 오른쪽 손으로 누름
        ry, rx = cur_right
        t += cal_dist(ry, rx, ty, tx) + 1
        cur_right = key_dict[s]

print(t)
