let s1 = "abhishek";
let n = s1.length;
let maxLength = 0;
let left = 0;

let Counts = new Array(128).fill(0);

for (let right = 0; right < n; right++) {
    let rightChar = s1.charAt(right);
    let rightCharCode = s1.charCodeAt(right);
    
    Counts[rightCharCode]++;
    
    while (Counts[rightCharCode] > 1) {
        let leftCharCode = s1.charCodeAt(left);
        Counts[leftCharCode]--;
        left++;
    }
    
    let currentWindowLength = right - left + 1;
    if (currentWindowLength > maxLength) {
        maxLength = currentWindowLength;
    }
}

console.log("Original String: " + s1);
console.log("Max Unique Substring Length: " + maxLength);