# Football Team (5358번)
while True:
    try:
        s = input().rstrip()
        ret = ""
        for w in s:
            if w == "i":
                ret += "e"
            elif w == "e":
                ret += "i"
            elif w == "I":
                ret += "E"
            elif w == "E":
                ret += "I"
            else:
                ret += w
        print(ret)
    except EOFError:
        break

