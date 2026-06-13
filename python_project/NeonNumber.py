""" n = 9
sum = 0
square =  n*n
temp = square
print (square) 
while temp>0:
    digit = temp%10
    sum = sum + digit
    temp = temp/10
   

print (sum)
print (digit)
if sum == n:
    print (n,  " is a Neon Number")
else:
    print (n, " is not a Neon Number") """

n = 9
sum = 0
square = n * n
temp = square

print("Square:", square) 

while temp > 0:
    digit = temp % 10      # Pull the last digit from temp, not square
    sum = sum + digit      # Add it to the running sum
    temp = temp // 10      # Use // for integer floor division

print("Sum of digits:", sum)
if sum == n:
    print(n, "is a Neon Number")
else:
    print(n, "is not a Neon Number")