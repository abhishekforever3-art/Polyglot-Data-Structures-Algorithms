s1 = "Abhishek"
s2 = ""
length = len(s1)
# In Python, / gives a float (4.0). We use // for integer division to get a clean whole number (4).
midpoint = length // 2

for i in range(0, midpoint):
    s2 = s2 + s1[i]

print("Original String: " + s1)
print("Total Length   : " + str(length))
print("Midpoint Index : " + str(midpoint))
print("First Half Only: " + s2)