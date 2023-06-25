# 나는 친구가 적다 (Large) (16172번)
import sys, re
input = sys.stdin.readline

S = input().rstrip()
K = input().rstrip()

re_s = re.sub("[0-9]", "", S) # 0 ~ 9를 ""(공백)으로 바꿈
print(1 if K in re_s else 0)