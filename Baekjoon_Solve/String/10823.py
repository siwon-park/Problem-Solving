# 더하기 2 (10823번)
# import sys
# input = sys.stdin.readline

# readlines를 하거나 해야 함
S = ""
while True:
    try:
        S += input().rstrip()
    except EOFError:
        break

print(sum(map(int, S.split(','))))

