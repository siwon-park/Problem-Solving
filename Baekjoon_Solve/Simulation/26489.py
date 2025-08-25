# Gum Gum for Jay Jay (26489번)
n = 0
while True:
    try:
        s = input().rstrip()
        n += 1
    except EOFError:
        break

print(n)

