text = "abcdef"
startChar = 'b'
endChar = 'e'

startIndex = -1
endIndex = -1
length = len(text)

for i in range(0, length):
    if text[i] == startChar:
        startIndex = i
        break 

if startIndex != -1:
    for i in range(startIndex + 1, length):
        if text[i] == endChar:
            endIndex = i
            break 

if startIndex == -1 or endIndex == -1:
    print("Error: One or both boundary characters were not found.")
else:
    trappedText = ""
    
    for i in range(startIndex + 1, endIndex):
        trappedText = trappedText + text[i]
        
    # 5. Output results
    print("Original Text   : " + text)
    print("Start Border    : '" + startChar + "' at index " + str(startIndex))
    print("End Border      : '" + endChar + "' at index " + str(endIndex))
    print("Trapped Segment : \"" + trappedText + "\"")