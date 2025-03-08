import sys
input = sys.stdin.readline

# 진짜 메시지 (9324번)
N = int(input().rstrip())
for i in range(N):
    M = input().rstrip()
    lst = [0 for _ in range(26)]
    flag = True
    for j in range(len(M)):
        w = M[j]
        lst[ord(w) - 65] += 1
        if lst[ord(w) - 65] % 4 == 3:  # 4로 나누는 이유는 3번 등장 후 삽입하는 문자를 카운트하지 않기 위함
            if j + 1 >= len(M) or M[j + 1] != w:
                flag = False
                break
    if flag:
        print("OK")
    else:
        print("FAKE")

