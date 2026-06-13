s1 = "abc"
s2 = "xyz"
totalDistance = 0

for i in range(0, len(s1)):
    
    val1 = ord(s1[i])
    val2 = ord(s2[i])
    
    ascii1 = val1
    ascii2 = val2
    
    print("The ascii value of " + str(val1) + " " + str(ascii1))
    print("The ascii value of " + str(val2) + " " + str(ascii2))
    
   
    currentdistance = abs(val1 - val2)
    print(str(currentdistance) + "========")
    
    totalDistance = totalDistance + currentdistance

print("String 1: " + s1)
print("String 2: " + s2)
print("---------------------------------")
print("Cumulative ASCII Distance: " + str(totalDistance))