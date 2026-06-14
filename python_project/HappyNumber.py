n=int(input("Enter a number: "))
q=n
while (n!=1 and n!= 4):
    sum = 0
    temp = n
    while (temp>0):
        digit = temp%10
        sum = sum+ digit*digit
        temp = temp//10
    n=sum
    print ("1 ",sum)
    print ("2 ",temp)
    
if (n==1):
    print (q, " is a happy number")
else:
    print (q, " is not a happy number")