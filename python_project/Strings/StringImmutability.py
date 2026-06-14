s1 = "A"
print ("Initial Text   : " + s1)
print ("Initial Address: " + str(id(s1)))

for i in range (0,6):
    s1 = s1 + "X"
    print("Step " + str(i) + " Text   : " + s1)
    print("Step " + str(i) + " Address: " + str(id(s1)))
    print()