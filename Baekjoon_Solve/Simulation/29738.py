# 29738번
T = int(input().rstrip())
for t in range(T):
    n = int(input().rstrip())
    if n > 4500:
        print(f"Case #{t+1}: Round 1")
    elif n > 1000:
        print(f"Case #{t+1}: Round 2")
    elif n > 25:
        print(f"Case #{t+1}: Round 3")
    else:
        print(f"Case #{t+1}: World Finals")