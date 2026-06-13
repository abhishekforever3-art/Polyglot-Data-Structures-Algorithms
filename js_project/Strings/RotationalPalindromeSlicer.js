let s1 = "radars";
let n = s1.length;
let length = n - 1;

let palindromeSliceFound = false;
let s2 = "";

for (let start = 0; start <= n - length; start++) {
    let s3 = "";
    for (let j = 0; j < length; j++) {
        s3 = s3 + s1.charAt(start + j);
        console.log(s3);
    }
    
    let left = 0;
    let right = s3.length - 1;
    let ispalendrome = true;
    
    while (left < right) {
        if (s3.charAt(left) !== s3.charAt(right)) {
            ispalendrome = false;
            break;
        }
        right--;
        left++;
    }
    
    if (ispalendrome) {
        palindromeSliceFound = true;
        s2 = s3;
        break;
    }
}

console.log("Original Text (" + n + " letters): " + s1);
console.log("Target Slice Size (N-1) : " + length);
console.log("----------------------------------------");
if (palindromeSliceFound) {
    console.log("Result: TRUE! Found a palindrome slice: \"" + s2 + "\"");
} else {
    console.log("Result: FALSE. No substring slice of length " + length + " is a palindrome.");
}