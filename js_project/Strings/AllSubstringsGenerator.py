s1 = "abc"
length = len(s1)
print ("Generating all possible substrings for \"" + s1 + "\":\n")
for start in range (0, length):
    for end in range (start , length):
        sub = ""
        for i in range (start , end+1 ):
            sub = sub + s1[i]
        print ("Start: " + str(start) + ", End: " + str(end) + " -> \"" + sub + "\"")