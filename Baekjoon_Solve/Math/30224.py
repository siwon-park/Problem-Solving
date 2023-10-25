s = input().rstrip()
n = len(s)
m = int(s)
contain7 = False
for i in range(n):
    if s[i] == "7":
        contain7 = True

divide7 = False
if m % 7 == 0:
    divide7 = True

if contain7 == False and divide7 == False:
    print(0)
elif contain7 == False and divide7 == True:
    print(1)
elif contain7 == True and divide7 == False:
    print(2)
elif contain7 == True and divide7 == True:
    print(3)