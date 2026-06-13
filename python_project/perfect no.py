n = int(input("Enter a number: "))
sum_factors = 0

for i in range(1, n):
    if n % i == 0:
        sum_factors = sum_factors + i

if sum_factors == n:
    print(n, "is a perfect number")
else:
    print(n, "is not a perfect number")