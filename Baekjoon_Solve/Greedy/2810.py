# 컵홀더 (2810번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = input().rstrip()
people = len(lst)
lst = lst.replace("LL", "L")
cup_holder = len(lst) + 1
print(min(cup_holder, people))

