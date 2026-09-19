import numpy as np
import sys
# Creating a list with 100000 integers
list_1000000 = list(range(1000000))

#Creat a numoy array of 1000000 integers
array_1000000 = np.arange(1000000)

#Print the size of the list and the array bytes
print (f"Size of Python list: {sys.getsizeof(list_1000000)} bytes")
print (f"size of array: {array_1000000.nbytes} bytes")

#time how long it takes to sum the list and the array
import time
#sum the list
start = time.time()
sum_list = sum(list_1000000)
end_time = time.time()
list_sum_time = (end_time - start) * 1000

#sum the array
start = time.time()
sum_array = np.sum(array_1000000)
end_time = time.time()
array_sum_time = (end_time - start) * 1000

#print the time taken to sum the list and the array
print (f"Time taken to sum the list: {list_sum_time:.2f} millisecounds")
print (f"Time taken to sum the array: {array_sum_time:.2f} millisecounds")