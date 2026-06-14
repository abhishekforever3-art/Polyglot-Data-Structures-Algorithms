let s1 = "Abhishek";
let s2 = "";
let length = s1.length;
// In JS, division can result in decimals if the length is odd. 
// Math.floor() ensures we get a clean whole number just like Java's integer division.
let midpoint = Math.floor(length / 2);

for (let i = 0; i < midpoint; i++) {
    s2 = s2 + s1.charAt(i);
}

console.log("Original String: " + s1);
console.log("Total Length   : " + length);
console.log("Midpoint Index : " + midpoint);
console.log("First Half Only: " + s2);