let s1 = "Abhishek Java";

// To print things on the same line in JS without automatic newlines, 
// we accumulate the result into a string variable first, then print it.
let output = "";
for (let i = 0; i < s1.length - 1; i++) {
    if (i % 2 !== 0) {
        output = output + s1.charAt(i) + " ";
    }
}
console.log(output);