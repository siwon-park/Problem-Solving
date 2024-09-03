while True:
    try:
        line = input().rstrip()
        print(line.replace("iiing", "th"))
    except EOFError:
        break