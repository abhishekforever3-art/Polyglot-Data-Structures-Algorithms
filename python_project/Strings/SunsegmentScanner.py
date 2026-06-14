s1 = "Abhishek"
k = 5
totallength = len(s1)
Startindex = totallength - k

print("Scanning \"" + s1 + "\" with window size K = " + str(k) + ":\n")

if k > totallength or k <= 0:
    print("Error: Invalid window length K.")
else:
    for i in range(0, Startindex):
        s2 = ""
        for j in range(0, k):
            s2 = s2 + s1[i + j]
            
        print("Window at Index " + str(i) + ": " + s2)