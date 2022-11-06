# 단축키 지정(1283번)
#################################################################################
    # 문제: https://www.acmicpc.net/problem/1283
    # 문자열, 구현
    # 문제 조건에 따라 구현을 잘 해주면 되는 문제.
    # 공백을 기준으로 나눠진 각 단어의 첫 글자만 일단 단축키로 지정되었는지 확인하고, 지정되지 않았다면 등록을 해준 다음
    # 공백을 포함한 나머지 문자들은 그대로 함께 출력해준다.
    # 만약 각 단어의 첫번째 글자들이 모두 단축키로 지정되었다면, 그 다음부터는 해당 문장의 처음부터, 또는 각 모든 단어의 처음부터
    # 단축키가 지정 안 된 제일 먼저 등장하는 알파벳에 대해 단축키로 지정하고 그 다음부터는 그대로 출력하면 된다.
    # flag 변수와 break를 통해서 조건을 컨트롤했다. 문제는 풀었지만, 잘 푼 것인지는 모르겠다.
#################################################################################
import sys
input = sys.stdin.readline

N = int(input())
short_cut = set()
for _ in range(N):
    words = list(input().split())
    M = len(words)
    ret = []
    flag = False
    for i in range(M): # 각 단어의 첫 글자가 단축키로 지정되었는지 확인함
        s = words[i][0].upper()
        if s not in short_cut:
            short_cut.add(s)
            words[i] = "[" + words[i][0] + "]" + words[i][1:]
            flag = True
            break
    if not flag: # 왼쪽에서 부터 차례대로 알파벳을 보면서 단축키로 지정
        for i in range(M):
            word = ""
            for w in words[i]:
                s = w.upper()
                if s not in short_cut and not flag:
                    short_cut.add(s)
                    word += "[" + w + "]"
                    flag = True
                else:
                    word += w
            words[i] = word
    print(" ".join(words))
