# 줄 세기 (4806번)
cnt = 0
while True:
    try:
        a = input()
        cnt += 1
    except EOFError:
        break

print(cnt)
