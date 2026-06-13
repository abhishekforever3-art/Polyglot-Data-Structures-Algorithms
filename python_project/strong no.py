import math

n = int(input("Enter a number: "))
temp = n
sum_factorial = 0

while temp > 0:
    digit = temp % 10
    sum_factorial += math.factorial(digit)
    temp //= 10

if sum_factorial == n:
    print(n, "is a strong number")
else:
    print(n, "is not a strong number")