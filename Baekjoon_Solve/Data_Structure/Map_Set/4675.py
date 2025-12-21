import sys
from collections import defaultdict

input = sys.stdin.readline

# Word Amalgamation (4675번)
anagram_map = defaultdict(set)

while True:
    word = input().strip()
    if word == "XXXXXX":
        break
    sorted_word = ''.join(sorted(word))
    anagram_map[sorted_word].add(word)

while True:
    query = input().strip()
    if query == "XXXXXX":
        break
    sorted_query = ''.join(sorted(query))
    candidates = anagram_map.get(sorted_query, set())

    if not candidates:
        print("NOT A VALID WORD")
    else:
        for w in sorted(sorted(candidates)):
            print(w)
    print("******")

