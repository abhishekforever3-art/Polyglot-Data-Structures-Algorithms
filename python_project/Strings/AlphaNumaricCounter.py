s1 = "Abhi 2026!"
letterCount = 0
digitcount = 0
symboleCount = 0
for i in range (0, len(s1)):
    x = s1[i]
    if x.isalpha():
        letterCount = letterCount + 1
    elif x.isdigit():
        digitcount = digitcount + 1
    elif x.isspace():
        pass
    else:
        symboleCount = symboleCount + 1

print("Original Text: \"" + s1 + "\"")
print("-------------------------")
print("Letters count: " + str(letterCount))
print("Digits count : " + str(digitcount))
print("Symbols count: " + str(symboleCount))