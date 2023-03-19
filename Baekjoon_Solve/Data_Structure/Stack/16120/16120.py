import sys
input = sys.stdin.readline


def is_ppap(s: str) -> str:
    stack = []  # 스택
    n = len(s)  # 문자열의 길이
    size = 0  # 스택 사이즈
    for i in range(n):
        w = s[i]  # 단어
        if not stack:
            stack.append(w)
            size += 1
        else:
            stack.append(w)
            size += 1
            while size >= 4:  # 스택의 길이가 4이상이면
                words = stack[-4] + stack[-3] + stack[-2] + stack[-1]  # 스택의 맨 위 4개의 문자열
                if words == "PPAP":  # 4개 연속된 문자열으 PPAP이면
                    for _ in range(4):  # 4개를 스택에서 뽑은 다음에
                        stack.pop()
                        size -= 1
                    stack.append("P")  # "P"를 삽입함
                    size += 1
                else:  # 무한 루프 방지를 위한 break문
                    break

    if stack == ["P"]:  # 스택에 마지막에 남아있는 문자열이 "P" 하나 뿐이면 PPAP 문자열이다
        return "PPAP"
    return "NP"


S = input().rstrip()
ret = is_ppap(S)
print(ret)