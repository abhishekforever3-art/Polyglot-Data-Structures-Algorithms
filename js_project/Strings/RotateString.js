let text = "Abhishek";
let k = 3;
let length = text.length;

let rotatedResult = "";

// 1. Loop backward for k items
for (let i = length - 1; i >= length - k; i--) {
    rotatedResult = rotatedResult + text.charAt(i);
}

// 2. Loop forward for remaining items
for (let i = 0; i < length - k; i++) {
    rotatedResult = rotatedResult + text.charAt(i);
}

// 3. Print the final result
console.log("Original String: " + text);
console.log("Rotated by K'th Position Result  : " + rotatedResult);