# 28249번
_dict = {"Poblano": 1500, "Mirasol": 6000, "Serrano": 15500, "Cayenne": 40000, "Thai": 75000, "Habanero": 125000}
n = int(input().rstrip())
ans = 0
for i in range(n):
    ans += _dict.get(input().rstrip())

print(ans)
    