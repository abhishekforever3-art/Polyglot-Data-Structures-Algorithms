n = int(input("Enter a number: "))
reverse_n = 0


temp_n = abs(n)

while temp_n > 0:
    digit = temp_n % 10
    reverse_n = (reverse_n * 10) + digit
    temp_n = temp_n // 10


if n < 0:
    reverse_n = -reverse_n

print("Reversed number:")
print(reverse_n)