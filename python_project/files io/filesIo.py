#---opening a file in read mode---

# f = open ("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "r" )
# data = f.read()
# print(data)
# print(type(data))
# f.close()

# -------------------------------------------------------------------------------------------

# f = open ("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "r" )
# data = f.read()
# line1 = f.readline()
# print(line1)
# line2 = f.readline()
# print(line2)
# print (data)
# f.close()

# -------------------------------------------------------------------------------------------

#---writting to a file---

# f = open ("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "a" )

# f.write("\nThis is a new another line added to the file. 123")

# f.close()

# -------------------------------------------------------------------------------------------


#---creating a new file in write mode---

# f = open ("C:\\Vs Code projects\\python_project\\files io\\sample.txt", "w" )
# f.close()

# -------------------------------------------------------------------------------------------


#---appending to open file that is not present in the directory---

# f = open ("C:\\Vs Code projects\\python_project\\files io\\sample.txt", "a")
# f.close()

# -------------------------------------------------------------------------------------------


# --- there is a stack overflow article on this topic, you can check it out here: https://stackoverflow.com/questions/1761051/how-to-create-a-file-if-it-does-not-exist-in-python
# --- theres is also a python documentation on this topic, you can check it out here: https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files
#--- thers is also a stack overfloe article called Difference between modes a, a+, w, w+ and r+ in built-in open() function , you can check it out here: https://stackoverflow.com/questions/1466000/difference-between-modes-a-a-w-w-and-r-in-the-built-in-open-function

# The argument mode points to a string beginning with one of the following
#  sequences (Additional characters may follow these sequences.):

#  ``r''   Open text file for reading.  The stream is positioned at the
#          beginning of the file.

#  ``r+''  Open for reading and writing.  The stream is positioned at the
#          beginning of the file.

#  ``w''   Truncate file to zero length or create text file for writing.
#          The stream is positioned at the beginning of the file.

#  ``w+''  Open for reading and writing.  The file is created if it does not
#          exist, otherwise it is truncated.  The stream is positioned at
#          the beginning of the file.

#  ``a''   Open for writing.  The file is created if it does not exist.  The
#          stream is positioned at the end of the file.  Subsequent writes
#          to the file will always end up at the then current end of file,
#          irrespective of any intervening fseek(3) or similar.

#  ``a+''  Open for reading and writing.  The file is created if it does not
#          exist.  The stream is positioned at the end of the file.  Subse-
#          quent writes to the file will always end up at the then current
#          end of file, irrespective of any intervening fseek(3) or similar.

# 'r'    open for reading (default)
# 'w'    open for writing, truncating the file first
# 'x'    open for exclusive creation, failing if the file already exists
# 'a'    open for writing, appending to the end of the file if it exists
# ----
# 'b'    binary mode
# 't'    text mode (default)
# '+'    open a disk file for updating (reading and writing)
# 'U'    universal newlines mode (for backwards compatibility; should not be used in new code)

# Source - https://stackoverflow.com/a/30931305
# Posted by industryworker3595112, modified by community. See post 'Timeline' for change history
# Retrieved 2026-08-06, License - CC BY-SA 4.0

#                   | r   r+   w   w+   a   a+
# ------------------|--------------------------
# read              | +   +        +        +
# write             |     +    +   +    +   +
# write after seek  |     +    +   +
# create            |          +   +    +   +
# truncate          |          +   +
# position at start | +   +    +   +
# position at end   |                   +   +

# -------------------------------------------------------------------------------------------


# f= open("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "a+") 
# # r+ will over right the file from the start of the file, if you want to append to the file use a+ instead of r+.
# f.write("abc")
# f.close()

# -------------------------------------------------------------------------------------------


# f = open("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "r+") 
# # pointer is at the start of the file, so it will over right the file from the start of the file, if you want to append to the file use a+ instead of r+.
# f. write("abc")  # now the pointer is at the end of abc so it will read the file from the end of abc, so it will read the rest of the file after abc.
# print (f.read())
# f.close()

# -------------------------------------------------------------------------------------------


# f = open("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "w+") 
# # now the file is truncated to zero length, so it will over right the file from the start of the file, if you want to append to the file use a+ instead of w+.
# #f. write("abc")  
# print (f.read())
# f.write("abc")  # now the pointer is at the end of abc so it will read the file from the end of abc, so it will read the rest of the file after abc.
# print (f.read()) # it will not read anything because the pointer is at the end of the file, so it will read nothing.
# f.close()

# -------------------------------------------------------------------------------------------


# f = open ("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "a+") 
# # now the file is truncated to zero length, so it will over right the file from the start of the file, if you want to append to the file use a+ instead of w+.
# f.write("\nThis is a new another line added to the file. 123")
# #now the pointer is after the abc and \n will make the pointer to go next line and it will add new line to the file and pointer is at the end now.
# print (f.read()) # it will not read anything because the pointer is at the end of the file, so it will read nothing.
# f.close()

# -------------------------------------------------------------------------------------------


# r+ = read and write, pointer at the start of the file, if the file does not exist it will throw an error, and no truncation of the file.
# w+ = read and write, pointer at the start of the file, if the file does not exist it will create a new file, and truncation of the file.
# a+ = read and write, pointer at the end of the file, if the file does not exist it will create a new file, and no truncation of the file.

# -------------------------------------------------------------------------------------------


# with Syntax;


# read


# with open("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "r") as f:
#     data = f.read()
#     print(data)
#     print(type(data)) # there is no need to close the file when using with syntax, it will automatically close the file after the block of code is executed.

# -------------------------------------------------------------------------------------------



# write

# with open("C:\\Vs Code projects\\python_project\\files io\\demo.txt", "w") as f: # this will overwrite the file with the given content in f.write("This is a new line added to the file. 123")
#     f.write("This is a new line added to the file. 123") 

# -------------------------------------------------------------------------------------------


# deleting a file
# using os module
# module (like a xode library) is a file written by another programmer that generally has a functions we can use in ouer code.

# import os
# os.remove ("C:\\Vs Code projects\\python_project\\files io\\sample.txt") # this will delete the file sample.txt from the directory, if the file does not exist it will throw an error.

# -------------------------------------------------------------------------------------------


#excersise - create a new file and write some content to it, then read the content of the file and print it to the console, then delete the file.
# with open("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "w") as f:
#     f.write("hi every one\nwe are learning Files Io\n")
#     f.write("using python\ni like programing in python.")


# -------------------------------------------------------------------------------------------

#write a function tahat replaces all occurances of "python" with "java" in a file and saves the changes to the same file.

# with open("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "r") as f:
# def replace_word_in_file():
#     with open("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "r") as f:
#         data = f.read()
    
#     data = data.replace("python", "java")
    
#     with open("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "w") as f:
#         f.write(data)
# replace_word_in_file()

# -------------------------------------------------------------------------------------------


#search if a  word "learning " exists in the file or not.
# def search_word_in_file():
#     word = "learning"
#     with open("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "r") as f:
#         data = f.read()
    
#         if (word in data):
#             print(f"{word} exists in the file.")
#         else:
#          print(f"{word} does not exist in the file.")
# search_word_in_file()

# -------------------------------------------------------------------------------------------


# write a founction in which liene of the file dose the word "learning" occur first not exist return -1.

# def search_word_in_file():
#     word = "learning"
#     date = True 
#     line_no = 1
#     with open ("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "r") as f:
#         while date:
#             data = f.readline()
#             if (word in data):
#                 print(f"{word} exists in the file at line number {line_no}.")
#                 date = False
#                 return
#             line_no += 1
#     return -1
# print(search_word_in_file())


# -------------------------------------------------------------------------------------------


#from a file containing numbers separated by commas, print the count of even numbers.

# with open ("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "r") as f:
#     data = f.read() # fetching the data from the file
#     print (data)
    
#     num = ""
#     for i in range (len (data)):
#         print(data[i])
#         if data[i] == ",":
#             print (int (num.strip()))
#             num = ""
#         else:
#             num += data[i]
#     print(num)
    
# -------------------------------------------------------------------------------------------

    
# with using split() method

# count = 0
# with open ("C:\\Vs Code projects\\python_project\\files io\\exercise.txt", "r") as f:
#     data = f.read() # fetching the data from the file
#     print (data)
    
#     nums = data.split(",") # splitting the data by comma and storing it in a list
#     for value in nums :
#         if (int(value) % 2 == 0): # checking if the number is even or not
#             count += 1 # incrementing the count of even numbers
    
# print(f"Count of even numbers: {count}")

# -------------------------------------------------------------------------------------------

# In Python, a stream is an abstraction used to read or write a sequence of data sequentially. Instead of loading an entire large file into RAM all at once, 
# streams process data continuously—chunk by chunk or character by character.

# Byte Streams (Binary Mode)

# A Byte Stream handles raw 8-bit bytes (bytes object). It performs no translation, no encoding conversion, and no line-ending changes.


# # Writing raw bytes (e.g., creating a simple binary file)
# with open("data.bin", "wb") as f:
#   f.write(b"\x48\x65\x6c\x6c\x6f")  # Hex values for "Hello"

# # Reading raw bytes
# with open("data.bin", "rb") as f:
#   raw_data = f.read()
#   print(raw_data)  # Output: b'Hello'
#   print(type(raw_data))  # Output: <class 'bytes'>

# -------------------------------------------------------------------------------------------

# Character Streams (Text Mode)
# A Character Stream handles human-readable Unicode characters (str object). It automatically translates raw bytes into readable characters based on a 
# specified text encoding (like utf-8) and normalizes line breaks.


# # Writing text (automatically encoded to bytes behind the scenes)
# with open("notes.txt", "w", encoding="utf-8") as f:
#   f.write("Hello Python! 🚀")

# -------------------------------------------------------------------------------------------

# # Reading text (automatically decoded back to a string)
# with open("notes.txt", "r", encoding="utf-8") as f:
#   text_data = f.read()
#   print(text_data)  # Output: Hello Python! 🚀
#   print(type(text_data))  # Output: <class 'str'>

# -------------------------------------------------------------------------------------------


# Serialization is the process of converting a complex data structure or programming object (like a Python dictionary, list, or custom class instance) 
# into a flat format—such as a stream of bytes or a string—so it can be easily stored in a file, saved to a database, or transmitted across a network.

# Data Persistence: RAM is temporary; when a program closes, all data in memory is lost. Serialization lets you save state to a file on disk.

# Network Communication: You cannot send a live Python dictionary directly across the internet. You must serialize it into bytes or text (like JSON) first.
# -------------------------------------------------------------------------------------------


# 1. The pickle Module (Binary Serialization)

# What it does: Serializes almost any native Python object (dictionaries, lists, custom classes, functions) into a byte stream.

# Best used for: Saving internal program states or objects locally. (Warning: Never unpickle untrusted data, as it can execute malicious code).

# import pickle

# data = {"name": "Alice", "scores": [95, 88, 92], "active": True}

# # 1. Serialization (Writing object to a binary file)
# with open("savegame.pkl", "wb") as f:
#   pickle.dump(data, f)  # Dumps object into byte stream

# # 2. Deserialization (Reading binary file back into an object)
# with open("savegame.pkl", "rb") as f:
#   loaded_data = pickle.load(f)
#   print(loaded_data)
#   print(type(loaded_data))  # Output: <class 'dict'>

# -------------------------------------------------------------------------------------------


# 2. The json Module (Text Serialization)

# import json

# user = {"username": "code_ninja", "id": 42, "skills": ["Python", "Java"]}

# # 1. Serialization (Writing dictionary as a JSON string to a text file)
# with open("user.json", "w", encoding="utf-8") as f:
#   json.dump(user, f, indent=4)

# # 2. Deserialization (Reading JSON text file back into a dictionary)
# with open("user.json", "r", encoding="utf-8") as f:
#   loaded_user = json.load(f)
#   print(loaded_user)
#   print(type(loaded_user))  # Output: <class 'dict'>