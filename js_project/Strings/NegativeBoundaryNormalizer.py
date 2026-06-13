s1 = "Abhishek"
start = -3
end = -1
length = len(s1)
if start<0:
    start = length + start
if end < 0:
    end = length + end
if start <0 or end >length or start > end :
    print ("Error: Normalized indices out of practical string bounds.")
else:
    slice = ""
    for i in range (start, end):
        slice = slice + s1[i]
    print("------------------------------------")
    print("Normalized Positive Start: " + str(start))
    print("Normalized Positive End  : " + str(end))
    print("Extracted Result         : \"" + slice + "\"")