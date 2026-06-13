s1 = "radars"
n = len(s1)
length = n - 1

palindromeSliceFound = False
s2 = ""

for start in range(0, n - length + 1):
    s3 = ""
    for j in range(0, length):
        s3 = s3 + s1[start + j]
        print(s3)  
        
    left = 0
    right = len(s3) - 1
    ispalendrome = True
    
    while left < right:
        if s3[left] != s3[right]:
            ispalendrome = False
            break
        right = right - 1
        left = left + 1
        
    if ispalendrome:
        palindromeSliceFound = True
        s2 = s3
        break

print("Original Text (" + str(n) + " letters): " + s1)
print("Target Slice Size (N-1) : " + str(length))
print("----------------------------------------")
if palindromeSliceFound:
    print("Result: TRUE! Found a palindrome slice: \"" + s2 + "\"")
else:
    print("Result: FALSE. No substring slice of length " + str(length) + " is a palindrome.")