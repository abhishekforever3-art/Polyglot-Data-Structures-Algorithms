s1 = "Abhishek"
k =3
length = len(s1)
rotatedResult = ""

for i in range (length-1, length-k-1, -1):
    rotatedResult = rotatedResult + s1[i]

for i in range (0, length-k):
    rotatedResult = rotatedResult + s1[i]
    
print("Original String: " + s1)
print("Rotated by K'th Position Result  : " + rotatedResult)