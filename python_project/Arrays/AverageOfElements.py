a = [10, 20, 30, 40, 50]
grand_total = sum(a)
highest = max(a)
lowest = min(a)
adjusted_sum = grand_total - highest - lowest
adjusted_count = len(a) - 2
final_average = adjusted_sum / adjusted_count
print("The average excluding extremes is: " + str(final_average))
print (a)
print (grand_total)
print(highest)
print(lowest)
print(adjusted_count)