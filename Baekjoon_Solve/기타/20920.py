# 영단어 암기는 괴로워(20920번)
#####################################################################################################
    # 문제: https://www.acmicpc.net/problem/20920
    # 정렬, 딕셔너리
    # 다 풀어놓고서는 어이없는 실수? 때문에 틀렸다. 뭐 실수라기 보다는 잘못 알고 있었던 것 같다.
    # lst.sort(key=lambda x: (-x[1], -len(x[0])))으로 정렬하여, 등장 빈도가 많은 순, 단어 길이가 긴 순으로 정렬하면
    # 당연히 사전순 정렬은 3순위로 자동적으로 정렬되는 줄 알았다.
    # 하지만 이는 내 착각이었고, lst.sort(key=lambda x: (-x[1], -len(x[0]), x[0]))와 같이 작성해줘야한다.
#####################################################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
count_dict = dict()
for _ in range(N):
    word = input().rstrip()
    if len(word) >= M:
        count_dict[word] = count_dict.get(word, 0) + 1

lst = list(count_dict.items())
lst.sort(key=lambda x: (-x[1], -len(x[0]), x[0])) # 등장 빈도, 단어 길이, 알파벳 사전 순으로 정렬

# print(lst)
for w, c in lst:
    print(w)
