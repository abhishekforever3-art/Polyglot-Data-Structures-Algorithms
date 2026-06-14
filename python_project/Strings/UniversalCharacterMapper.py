s1 = "abhishek🚀"


visualSymbols = len(s1)


rawCodeUnits = len(s1.encode('utf-16-le')) // 2

print("Original Text   : " + s1)
print("---------------------------------------")
print("Internal Code Units (UTF-16 Units)  : " + str(rawCodeUnits))
print("Visual Symbols (len(s1))            : " + str(visualSymbols))
print("---------------------------------------")

print("CRITICAL LESSON: Printing using a standard character loop:")


print("Output: ", end="")

for i in range(0, len(s1)):
    print("[" + s1[i] + "] ", end="")

