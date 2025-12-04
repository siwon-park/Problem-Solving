import sys

input = sys.stdin.readline

# 대전과학고등학교를 사랑하십니까? (34691번)
while True:
    s = input().rstrip()
    if s == "end":
        break
    if s == "animal":
        print("Panthera tigris")
    elif s == "tree":
        print("Pinus densiflora")
    elif s == "flower":
        print("Forsythia koreana")

