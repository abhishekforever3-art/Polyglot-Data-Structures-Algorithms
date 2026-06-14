n = int(input("Enter the number: "))
sum_factors = 0

for i in range(1, n + 1):
    if n % i == 0:
        sum_factors = sum_factors + i

print("The sum of factors is:")
print(sum_factors)