s1 = "abhishek.forever3@.gmail.com"
dotIndex = -1
length = len(s1)


for i in range(length - 1, -1, -1):
    if s1[i] == '.':
        dotIndex = i
        break

if dotIndex == -1 or dotIndex == length - 1:
    print("Error: No valid file extension found.")
else:
    extension = ""
    for i in range(dotIndex + 1, length):
        extension = extension + s1[i]
        
    print("Full Filename : " + s1)
    print("Dot Located At: Index " + str(dotIndex))
    print("Extension Only: " + extension)