a=[]
for i in range (5):
    a.append((i+1)*2.5)
    print (a[i])
min =a[0]
max = a[0]
for i in range (len(a)):
    if a[i]<min:
        min = a[i]
    if a[i]>max:
        max = a[i]
difference = max - min
print (min, " is the min value")
print (max, " is the max value")
print (difference, " is the difference value")