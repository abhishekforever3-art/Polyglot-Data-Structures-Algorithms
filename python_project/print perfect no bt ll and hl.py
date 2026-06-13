ll = int(input("Enter lower limit: "))
hl = int(input("Enter higher limit: "))

for num in range(ll, hl + 1):
    if num > 0:
        sum_factors = 0
        for i in range(1, num):
            if num % i == 0:
                sum_factors = sum_factors + i
        
        if sum_factors == num:
            print(num)
            