s1 = "abhishek"
n = len(s1)
maxLength = 0
left = 0

# Initializing a frequency array of size 128 with zeros
Counts = [0] * 128

for right in range(0, n):
    rightChar = s1[right]
    
    # ord() gets the ASCII integer value of the character
    Counts[ord(rightChar)] = Counts[ord(rightChar)] + 1

    
    # Shrink the window if a duplicate is found
    while Counts[ord(rightChar)] > 1:
        leftChar = s1[left]
        Counts[ord(leftChar)] = Counts[ord(leftChar)] - 1
        left = left + 1
        
    currentWindowLength = right - left + 1
    if currentWindowLength > maxLength:
        maxLength = currentWindowLength

print("Original String: " + s1)
print("Max Unique Substring Length: " + str(maxLength))