a=[3,4,5,6,7,5,4,3]
target = 5
firstIndex= -1
lastIndex = -1
for i in range(len(a)):
    if a[i]== target:
        if firstIndex ==-1:
            firstIndex=i
        lastIndex = i
print(target, " is the target")
print("First index: " + str(firstIndex))
print("Last index: " + str(lastIndex))