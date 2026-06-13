text = " abhi gl"
marker = "i"
if marker in text:
    end = text.find(marker)
    print("Extracted: " + text[0:end])
else:
    print("Error: Marker not found.")
