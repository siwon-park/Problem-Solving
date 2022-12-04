# 매직 스타 (3967번)
###############################################################################################
    # 문제: https://www.acmicpc.net/problem/3967
    # 백트랙킹
    # 무지성으로 순열을 구성하여 마지막에 체크하는 방식으로 백트랙킹을 구현하면 9%에서 시간초과가 난다.
    # 따라서 매번 check함수를 호출해서 확인하는 방식을 적용하였다. 각 라인별 숫자는 4개씩 있어야 하므로
    # 숫자가 4개가 채워졌고, 합이 26이 아니면 False를 return하여 백트랙킹을 하였다.
    # 간단한 문제였지만, 코드가 너무 길어서 풀이가 조금 마음에는 들지 않는다.
###############################################################################################
import sys
input = sys.stdin.readline


def check():
    s1 = [graph[0][4], graph[1][3], graph[2][2], graph[3][1]]
    s2 = [graph[1][1], graph[1][3], graph[1][5], graph[1][7]]
    s3 = [graph[0][4], graph[1][5], graph[2][6], graph[3][7]]
    s4 = [graph[3][1], graph[3][3], graph[3][5], graph[3][7]]
    s5 = [graph[1][1], graph[2][2], graph[3][3], graph[4][4]]
    s6 = [graph[1][7], graph[2][6], graph[3][5], graph[4][4]]
    sum_lst1, sum_lst2, sum_lst3, sum_lst4, sum_lst5, sum_lst6 = [], [], [], [], [], []
    for s in s1:
        if s != "x":
            sum_lst1.append(ord(s) - 64)
    if len(sum_lst1) == 4 and sum(sum_lst1) != 26:
        return False
    for s in s2:
        if s != "x":
            sum_lst2.append(ord(s) - 64)
    if len(sum_lst2) == 4 and sum(sum_lst2) != 26:
        return False
    for s in s3:
        if s != "x":
            sum_lst3.append(ord(s) - 64)
    if len(sum_lst3) == 4 and sum(sum_lst3) != 26:
        return False
    for s in s4:
        if s != "x":
            sum_lst4.append(ord(s) - 64)
    if len(sum_lst4) == 4 and sum(sum_lst4) != 26:
        return False
    for s in s5:
        if s != "x":
            sum_lst5.append(ord(s) - 64)
    if len(sum_lst5) == 4 and sum(sum_lst5) != 26:
        return False
    for s in s6:
        if s != "x":
            sum_lst6.append(ord(s) - 64)
    if len(sum_lst6) == 4 and sum(sum_lst6) != 26:
        return False
    return True


def backtrack(k):
    global ret, flag
    if flag:
        return
    if not check():
        return
    if k == N:
        temp = []
        for lst in graph:
            s = "".join(lst)
            temp.append(s)
        ret.append(temp)
        flag = True
        return
    for i in range(12):
        if not visited[i]:
            visited[i] = True
            y, x = xlst[k]
            graph[y][x] = alst[i]
            backtrack(k + 1)
            graph[y][x] = "x"
            visited[i] = False


graph = [list(input().rstrip()) for _ in range(5)]
alst = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"]
visited = [False] * 12
xlst = []
for i in range(5):
    for j in range(9):
        if graph[i][j] == "x":
            xlst.append((i, j))
        elif graph[i][j] != ".":
            visited[ord(graph[i][j]) - 65] = True

N = len(xlst)

ret = []
flag = False
backtrack(0)
for lst in ret[0]:
    print(lst)
