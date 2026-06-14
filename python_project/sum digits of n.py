n = int(input("Enter a number: "))
sum_digits = 0
n = abs(n)

while n > 0:
    digit = n % 10
    sum_digits = sum_digits + digit
    n = n // 10

print("The sum of digits is:")
print(sum_digits)