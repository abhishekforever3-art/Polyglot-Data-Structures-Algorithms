a= [1,2,3,4,5,6,7,8,9]
b=[]
for i in range (len(a)):
    if i%2!=0:
        b.append(a[i])
    else:
        b.append(a[i]*2)
print (a)
print (b)

