
ll = int(input("Enter lower limit: "))
hl = int(input("Enter higher limit: "))

for num in range(ll, hl + 1):
    if num % 2 == 0:
        print(num)