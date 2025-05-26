import sys

input = sys.stdin.readline

# 끊임없는 정렬과 창조함으로 (33574번)
q = int(input().rstrip())
lst = []
for i in range(q):
    query = list(map(int, input().rstrip().split()))
    if query[0] == 1:
        if query[1] == 1:
            lst.sort()
        else:
            lst.sort(reverse=True)
    else:
        if query[1] == 0:
            lst = [query[2]] + lst
        elif query[1] == len(lst):
            lst.append(query[2])
        else:
            lst.insert(query[1], query[2])

print(len(lst))
if lst:
    print(*lst)

