ll = int(input("Enter lower limit: "))
hl = int(input("Enter higher limit: "))

for num in range(ll, hl + 1):
    if num > 1:
        is_prime = True
        for i in range(2, num):
            if num % i == 0:
                is_prime = False
                break
        if is_prime:
            print(num)