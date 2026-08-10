# 1. Swap Two Numbers
# a = 10
# b = 50
# a, b = b, a
# print ("a = ",a)
# print ("b = ",b)
# -----------------------------------------------------------------------------------------------------------


#2. Add Two Numbers

# a = 15
# b = 20
# c = a+b
# print("Sun of given numbers = ",c)
# -----------------------------------------------------------------------------------------------------------


# 3. Check Even or Odd

# a = 30
# if a % 2 ==0:
#     print (a, "is even number")
# else :
#     print (a,"is an odd number")
# -----------------------------------------------------------------------------------------------------------


# 4. Check Positive, Negative or Zero

# n = float(input("Enter Your Number: "))
# if n>0:
#     print (n,"is a Positive number")
# elif n<0:
#     print (n, "is a negative number")
# else:
#     print ("Zero")
# -----------------------------------------------------------------------------------------------------------


# 5. Find Largest of 3 Numbers

# a = int(input("Enter first number: "))
# b = int(input("Enter second number: "))
# c = int(input("Enter third number: "))

# if a >= b and a >= c:
#     largest = a
# elif b >= a and b >= c:
#     largest = b
# else:
#     largest = c

# print("Largest number is", largest)
# -----------------------------------------------------------------------------------------------------------


# 6. Find Square & Cube

# n = int(input("Enter a number: "))

# square = n * n
# cube = n * n * n

# print("Square =", square)
# print("Cube =", cube)

# -----------------------------------------------------------------------------------------------------------

# 7. Check Leap Year

# n = int(input("Enter a number: "))

# year = int(input("Enter year: "))

# if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
#     print("Leap Year")
# else:
#     print("Not a Leap Year")

# -----------------------------------------------------------------------------------------------------------

# 8. Print Multiplication Table
# n = int(input("Enter a number: "))

# for i in range(1, 11):
#     print(f"{n} x {i} = {n * i}")  #an f-string (formatted string) allowing Python expressions inside {} to be evaluated and formatted directly into text.
    
# for i in range (1, 11):
#     result = n * i
    
#     print (n, "x", i, "=", result)

# -----------------------------------------------------------------------------------------------------------
# 9. Check Prime Number
# n = int(input("Enter a number: "))
# if n<=1:
#     print (n, " is not a Prime number")
    
# else:
#     for i in range (2, int(n**0.5) + 1): # checking the Squre root of n for the range
#         if n%i == 0:
#             print ("Not a Prime")
#             break
#     else:
#         print("Prime Number")

# -----------------------------------------------------------------------------------------------------------
# 10. Prime Numbers in a Range

# start = int(input("Start: "))
# end = int(input("End: "))

# for num in range (start, end+1):
#     if num <=1:
#         continue #tells Python to skip the rest of the loop and move immediately to the next number.
#     for i in range (2, int (num**0.5) +1):
#         if num%i == 0:
#             break
#     else:
#         print (num)


# -----------------------------------------------------------------------------------------------------------
# 11. Find Factorial
# n = int(input("Enter a number: "))
# fact = 1
# if n < 0:
#     print("Factorial is not defined")
# elif n == 0:
#     print("Factorial = 1")
# else:
#     for i in range(1, n + 1):
#         fact *= i
#     print(f"Factorial = {fact}")  # an f-string (formatted string) allowing Python expressions inside {} to be evaluated and formatted directly into text.

# -----------------------------------------------------------------------------------------------------------
# 12. Fibonacci Series
# In a Fibonacci sequence, each number is the sum of the two preceding ones, starting from 0 and 1

# n = int(input("Enter n terms: "))
# a, b = 0, 1
# print("Fibonacci Series:")

# for _ in range(n):
#     print(a, end=" ")
#     a, b = b, a + b  
# This is Python's tuple unpacking shortcut to update both variables at the exact same time. a becomes the old value of b. b becomes the sum of the old a + b


# -----------------------------------------------------------------------------------------------------------
# 13. Reverse a Number
# n = int(input("Enter a number: "))
# rev = 0
# while n>0:
#     digit = n%10
#     rev = rev *10 + digit
#     n = n// 10
# print(f"Reversed number = {rev}")    # an f-string (formatted string) allowing Python expressions inside {} to be evaluated and formatted directly into text.

# -----------------------------------------------------------------------------------------------------------
# 14. Palindrome Number
# n = int(input("Enter a number: "))
# temp = n
# rev = 0
# while n > 0:
#     digit = n % 10
#     rev = rev * 10 + digit
#     n //= 10

# if temp == rev:
#     print("Palindrome Number")
# else:
#     print("Not a Palindrome Number")

# -----------------------------------------------------------------------------------------------------------
# 15. Armstrong Number
# n = int(input("Enter a number: "))
# temp = n
# sum = 0
# digits = 0

# while temp > 0:
#     temp //= 10
#     digits += 1

# temp = n
# while temp > 0:
#     digit = temp % 10
#     sum += digit ** digits  # sum += digit ** digits: Raises that digit to the power of total digits ($3^3 = 27$) and adds it to sum.
#     temp //= 10

# if sum == n:
#     print("Armstrong Number")
# else:
#     print("Not an Armstrong Number")

# -----------------------------------------------------------------------------------------------------------
# 16. Sum of Digits
# n = int(input("Enter a number: "))
# s = 0
# while n > 0:
#     s += n % 10
#     n //= 10

# print("Sum of digits =", s)

# -----------------------------------------------------------------------------------------------------------
# 17. Count Digits
# n = int(input("Enter a number: "))
# count = 0
# if n == 0:
#     count = 1
# else:
#     while n > 0:
#         count += 1
#         n //= 10

# print("Total digits =", count)

# -----------------------------------------------------------------------------------------------------------
# 18. Find GCD (Greatest Common Divisor) of two numbers.
# a = int(input("Enter first number: "))
# b = int(input("Enter second number: "))

# while b != 0:
#     a, b = b, a % b

# print("GCD =", a)

# -----------------------------------------------------------------------------------------------------------
# 19. Find the LCM (Least Common Multiple) of two numbers.
# a = int(input("Enter first number: "))
# b = int(input("Enter second number: "))

# x, y = a, b
# while y > 0:
#     x, y = y, x % y  # Find the largest number that divides both (GCD)

# lcm = (a * b) // x # Use the formula (a * b) / GCD

# print("LCM =", lcm)

# -----------------------------------------------------------------------------------------------------------
# 20. Power of a Number
# x = int(input("Enter base (x): "))
# y = int(input("Enter power (y): "))
# result = 1

# for i in range(y):
#     result *= x

# print(f"{x} raised to the power {y} = {result}")

# -----------------------------------------------------------------------------------------------------------
# 21. Sum of First N Natural Numbers
# n = int(input("Enter n: "))
# total = n * (n + 1) // 2
# print("Sum =", total)

# -----------------------------------------------------------------------------------------------------------
# 22. Decimal to Binary
# n = int(input("Enter a decimal number: "))
# if n == 0:
#     print(0)
# else:
#     binary = ""
#     while n > 0:
#         binary = str(n % 2) + binary
#         n //= 2
#     print("Binary =", binary)

# -----------------------------------------------------------------------------------------------------------
# 23. Reverse a String
# s = input("Enter a string: ")
# rev = ""
# for ch in s:
#     rev = ch + rev
# print("Reversed string:", rev)

# -----------------------------------------------------------------------------------------------------------
# 24. Palindrome String
# s = input("Enter a string: ")
# s = s.lower()  # ignore case
# if s == s[::-1]: #Uses Python's slicing shortcut with a step of -1 to reverse the string.
#     print("Palindrome")
# else:
#     print("Not a Palindrome")

# -----------------------------------------------------------------------------------------------------------
# 25. Count Vowels & Consonants
# s = input("Enter a string: ")
# vowels = "aeiouAEIOU"
# v_count = 0
# c_count = 0

# for ch in s:
#     if ch.isalpha():
#         # Checks if the character is an alphabet letter (A-Z or a-z). Spaces (" "), numbers ("1"), and punctuation ("!") return False and are safely skipped.
#         if ch in vowels:
#             v_count += 1
#         else:
#             c_count += 1

# print("Vowels =", v_count)
# print("Consonants =", c_count)

# -----------------------------------------------------------------------------------------------------------
# 26. Count Words in a String
# s = input("Enter a string: ")
# words = s.split() # Breaks the string into individual words whenever it finds whitespace (spaces, tabs, or newlines) and puts them into a list. 
# count = len(words) # Counts how many items (words) are in the words list and stores that number in count
# print("Number of words:", count)

# -----------------------------------------------------------------------------------------------------------
# 27. Find String Length Without len()
# s = input("Enter a string: ")
# count = 0
# for ch in s:
#     count += 1
# print("Length =", count)

# -----------------------------------------------------------------------------------------------------------
# 28. Remove Spaces from String
# s = input("Enter a string: ")
# result = ""
# for ch in s:
#     if ch != " ":
#         result += ch
# print("String without spaces:", result)
# # OR result = s.replace(" ", "")

# -----------------------------------------------------------------------------------------------------------
# 29. Check Anagram
# An anagram is a word or phrase formed by rearranging the exact same letters of another (for example, "listen" and "silent", or "triangle" and "integral").
# s1 = input("Enter first string: ")
# s2 = input("Enter second string: ")

# s1 = s1.replace(" ", "").lower() # Removes all spaces so multi-word anagrams (like "conversational" and "voices rant on") can be compared accurately.
# s2 = s2.replace(" ", "").lower()

# if sorted(s1) == sorted(s2): #Rearranges all letters of the string into alphabetical order as a list. like "listen" becomes ['e', 'i', 'l', 'n', 's', 't'].
#     print("Anagram")
# else:
#     print("Not an Anagram")


# -----------------------------------------------------------------------------------------------------------
# 30. Find Maximum and Minimum Element in a List
# lst = list(map(int, input("Enter list elements separated by space: ").split()))
# # This single line does four things in sequence. 
# # input(...): Reads a line of text typed by the user. 
# # split(): Splits that text wherever there is a space into a list of string pieces
# # map(int, ...): Applies the int() function to every piece, converting the strings into actual numbers
# # list(...): Converts the mapped result into a Python list

# print("Maximum:", max(lst))
# print("Minimum:", min(lst))

# -----------------------------------------------------------------------------------------------------------
# 31. Second Largest Element in a List
# lst = list(map(int, input("Enter list elements separated by space: ").split()))

# unique_lst = list(set(lst)) #set(lst): Converts the list into a set, which automatically removes all duplicate numbers
# unique_lst.sort()#Sorts the list in ascending order (from smallest to largest).

# if len(unique_lst) >= 2:#Checks if there are at least two distinct numbers in the list.
    
#     print("Second Largest:", unique_lst[-2]) #unique_lst[-2]: Uses negative indexing to access the second-to-last item
# else:
#     print("No second largest element")

# -----------------------------------------------------------------------------------------------------------
# 32. Remove Duplicates from a List

# lst = list (map(int,input("enter list elements sperated by spaces").split()))
# unique_lst = list(dict.fromkeys(lst)) 
# # dict.fromkeys(lst): Creates a dictionary where the keys are the elements of lst. Since dictionary keys in Python cannot be duplicated, any repeated values are automatically ignored.
# print("List without duplicates:", unique_lst)

# -----------------------------------------------------------------------------------------------------------
# 33. Merge Two Lists
# l1 = list(map(int, input("Enter first list: ").split()))
# l2 = list(map(int, input("Enter second list: ").split()))
# merged = l1 + l2
# print("Merged List:", merged)

# -----------------------------------------------------------------------------------------------------------
# 34. Transpose a Matrix
# matrix = [[1, 2, 3], 
#           [4, 5, 6]]

# rows = len(matrix)        # 2
# cols = len(matrix[0])     # 3

# # 1. Create an empty result matrix with dimensions swapped (3 rows, 2 cols)
# transpose = []

# # 2. Outer loop iterates through each column of the original matrix
# for col in range(cols):
#     new_row = []
#     # Inner loop iterates through each row of the original matrix
#     for row in range(rows):
#         new_row.append(matrix[row][col]) 
#     transpose.append(new_row)

# print("Original Matrix:", matrix)
# print("Transposed Matrix:", transpose)

# -----------------------------------------------------------------------------------------------------------
# 35. Multiply Three Matrices
# Initialize 3x3 matrices with zeros
# a = [[0] * 3 for _ in range(3)] # Repeats the inner operation 3 times. The underscore _ is a Python convention meaning
# b = [[0] * 3 for _ in range(3)]
# c = [[0] * 3 for _ in range(3)]

# counter = 1


# if len(a) == len(b) and len(a[0]) == len(b[0]):
#     print("Dimension Check Passed! Both matrices are matching sizes.")
#     print("-------------------------------------------------")
    
#     print("Matrix A:")
#     for row in range(len(a)):
#         for col in range(len(a[row])):
#             a[row][col] = counter
#             print(a[row][col], end="\t")
#             counter += 1
#         print()

# print("-------------")
# print("Matrix A:") 

# count = 1
# for row in range(len(a)):
#     for col in range(len(b[row])):
#         b[row][col] = count
#         print(b[row][col], end="\t")
#         count += 1
#     print()

# print("--------------------------")

# print("Sum Matrix (C = A * B):")  
# for row in range(3):
#     for col in range(3):
#         c[row][col] = 0
        
#         for k in range(3):
#             c[row][col] = c[row][col] + a[row][k] * b[k][col]
            
#         print(c[row][col], end="\t")
#     print()


# -----------------------------------------------------------------------------------------------------------
# 36. Check Substring in a String
# main_str = input("Enter main string: ")
# sub_str = input("Enter substring to check: ")
# if sub_str in main_str:
#     print("Substring found!")
# else:
#     print("Substring not found!")

# -----------------------------------------------------------------------------------------------------------
# 37. Star Triangle
# n = int(input("Enter n: "))
# for i in range(1, n + 1):
#     for j in range(1, i + 1):
#         print("*", end=" ")
#     print()

# -----------------------------------------------------------------------------------------------------------
# 38. Inverted Triangle
# n = int(input("Enter n: "))
# for i in range(n, 0, -1):
#     for j in range(1, i + 1):
#         print("*", end=" ")
#     print()

# -----------------------------------------------------------------------------------------------------------
# 39. Pyramid Pattern
# n = int(input("Enter n: "))
# for i in range(1, n + 1):
#     print(" " * (n - i) + "* " * i)
#     # " " * (n - i): Multiplies a space character to create leading indentation, pushing the stars right so they center properly. As i increases, spaces decrease.
#     # "* " * i): Multiplies the string "* " (star followed by a space) i times to form the shape of the pyramid.

# -----------------------------------------------------------------------------------------------------------
# 40. Number Triangle
# n = int(input("Enter n: "))
# for i in range(1, n + 1):
#     for j in range(1, i + 1):
#         print(j, end=" ")
#     print()

# -----------------------------------------------------------------------------------------------------------
# 41. Floyd’s Triangle
# n = int(input("Enter n: "))
# num = 1
# for i in range(1, n + 1):
#     for j in range(1, i + 1):
#         print(num, end=" ")
#         num += 1
#     print()

# -----------------------------------------------------------------------------------------------------------
# 42. Tables from 1 to 10
# for i in range(1, 11):
#     print(f"Table of {i}")
#     #print(f"Table of {i}"): Prints a header line before each table (e.g., "Table of 1").
#     for j in range(1, 11):
#         print(f"{i} x {j} = {i * j}")
#         #f"{i} x {j} = {i * j}": Uses an f-string to format and print the equation and its calculated result.
#     print()

# -----------------------------------------------------------------------------------------------------------
# 43. Sum of First N Natural Numbers (Loop vs Formula)
# n = int(input("Enter n: "))
# total = 0
# for i in range(1, n + 1):
#     total += i
# print("Sum =", total)
# # Formula alternative: total = n * (n + 1) // 2
# -----------------------------------------------------------------------------------------------------------
# 44. Simple Calculator
# a = float(input("Enter first number: "))
# b = float(input("Enter second number: "))
# op = input("Enter operator (+, -, *, /, %): ")

# if op == "+":
#     print(a + b)
# elif op == "-":
#     print(a - b)
# elif op == "*":
#     print(a * b)
# elif op == "/":
#     if b != 0:
#         print(a / b)
#     else:
#         print("Cannot divide by zero")
# elif op == "%":
#     if b != 0:
#         print(a % b)
#     else:
#         print("Cannot divide by zero")
# else:
#     print("Invalid operator")

# -----------------------------------------------------------------------------------------------------------
# 45. Celsius to Fahrenheit
# c = float(input("Enter temperature in Celsius: "))
# f = (c * 9/5) + 32
# print("Temperature in °F:", f)

# -----------------------------------------------------------------------------------------------------------
# 46. Decimal to Binary
# n = int(input("Enter a decimal number: "))
# if n == 0:
#     binary = "0"
# else:
#     binary = ""
#     while n > 0:
#         binary = str(n % 2) + binary
#         n //= 2
# print("Binary =", binary)

# -----------------------------------------------------------------------------------------------------------
# 47. Binary to Decimal
# b = input("Enter a binary number: ")
# decimal = 0
# power = 0
# for digit in reversed(b):
#     # reversed(b): Reverses the string so the loop processes digits starting from the rightmost (least significant) bit, matching positional powers ($2^0, 2^1, 2^2, \dots$).
#     decimal += int(digit) * (2 ** power)
#     # int(digit) * (2 ** power): Converts the character ('0' or '1') to an integer and multiplies it by $2^\text{power}$.
#     power += 1
# print("Decimal =", decimal)
# -----------------------------------------------------------------------------------------------------------

# 48. Count Character Frequency
# s = input("Enter a string: ")
# freq = {}
# for ch in s:
#     if ch in freq:
#         freq[ch] += 1
#     else:
#         freq[ch] = 1

# print("Frequencies:")
# for ch, cnt in freq.items():
#     print(f"{ch}: {cnt}")
#     # print(f"{ch}: {cnt}"): Prints each character alongside how many times it appeared in the input string.

# -----------------------------------------------------------------------------------------------------------
# 49. Find Common Elements in Two Lists

# l1 = list(map(int, input("Enter first list (space separated): ").split()))
# l2 = list(map(int, input("Enter second list (space separated): ").split()))

# common = list(set(l1) & set(l2)) #& Operator: Computes the intersection of the two sets—returning only elements present in both sets.
# # set(l1) & set(l2): Converts both lists into sets, which automatically eliminates duplicates in each list.
# print("Common elements:", common)

# -----------------------------------------------------------------------------------------------------------

# 50. Guess the Number Game
import random

num = random.randint(1, 100) #random.randint(1, 100): Picks a secret integer at random between 1 and 100 (inclusive).
attempts = 0
print("Guess a number between 1 and 100")

while True:
    guess = int(input("Enter guess: "))
    attempts += 1
    if guess < num:
        print("Too small! Try again.")
    elif guess > num:
        print("Too large! Try again.")
    else:
        print(f"Correct! You guessed it in {attempts} attempt(s).")
        break
