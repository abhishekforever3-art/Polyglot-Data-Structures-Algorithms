ll = int(input("Enter lower limit: "))
hl = int(input("Enter higher limit: "))

for i in range(ll, hl + 1):
    if i % 2 != 0:
        print(i)