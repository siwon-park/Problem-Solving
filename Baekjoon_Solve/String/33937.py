import sys

input = sys.stdin.readline

# 태권도와 복싱을 합한 운동 (33937번)
A = input().rstrip()
B = input().rstrip()


def get_prefix(word: str) -> str:
    prefix = ""
    m = len(word)
    cnt = 0  # 모음 개수
    cnt2 = 0  # 첫번째 모음 이후 자음의 개수
    for i in range(m):
        if word[i] in "aeiou":
            cnt += 1
        elif cnt >= 1 and word[i] not in "aeiou":
            cnt2 += 1
            break
        prefix += word[i]
    if cnt == 0 or cnt2 == 0:  # 모음 개수가 0이거나 첫번째 모음 이후 자음이 없으면 공백 리턴
        return ""
    return prefix

prefix_a = get_prefix(A)
prefix_b = get_prefix(B)

if prefix_a == "" or prefix_b == "":
    print("no such exercise")
else:
    print(prefix_a + prefix_b)

