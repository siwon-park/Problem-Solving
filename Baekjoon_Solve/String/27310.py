import sys

input = sys.stdin.readline

# :chino_shock: (27310번)
emoji = input().rstrip()
print(len(emoji) + emoji.count(":") + emoji.count("_") * 5)
