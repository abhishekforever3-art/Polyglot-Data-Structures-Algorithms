s1 = "mymomgavemearacecarformynoonbirthday"
n = len(s1)

if n < 1:
    print("Empty string provided.")
else:
    maxLength = 0
    bestStart = 0

    for i in range(0, n):
        left1 = i
        right1 = i
        while left1 >= 0 and right1 < n and s1[left1] == s1[right1]:
            currentLen = right1 - left1 + 1
            if currentLen > maxLength:
                maxLength = currentLen
                bestStart = left1
            left1 = left1 - 1
            right1 = right1 + 1

        left2 = i
        right2 = i + 1 
        while left2 >= 0 and right2 < n and s1[left2] == s1[right2]:
            currentLen = right2 - left2 + 1
            if currentLen > maxLength:
                maxLength = currentLen
                bestStart = left2
            left2 = left2 - 1
            right2 = right2 + 1

    longestPalindrome = ""
    for i in range(bestStart, bestStart + maxLength):
        longestPalindrome = longestPalindrome + s1[i]

    print("Original String   : " + s1)
    print("Max Palindrome Len: " + str(maxLength))
    print("Longest Substring : \"" + longestPalindrome + "\"")