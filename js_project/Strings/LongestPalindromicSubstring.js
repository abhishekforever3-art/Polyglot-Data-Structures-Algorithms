let s1 = "Abhba";
let n = s1.length;

if (n < 1) {
    console.log("Empty string provided.");
} else {
    let maxLength = 0;
    let bestStart = 0;

    for (let i = 0; i < n; i++) {
        let left1 = i;
        let right1 = i;
        while (left1 >= 0 && right1 < n && s1.charAt(left1) === s1.charAt(right1)) {
            let currentLen = right1 - left1 + 1;
            if (currentLen > maxLength) {
                maxLength = currentLen;
                bestStart = left1;
            }
            left1--;
            right1++;
        }

        let left2 = i;
        let right2 = i + 1; 
        while (left2 >= 0 && right2 < n && s1.charAt(left2) === s1.charAt(right2)) {
            let currentLen = right2 - left2 + 1;
            if (currentLen > maxLength) {
                maxLength = currentLen;
                bestStart = left2;
            }
            left2--;
            right2++;
        }
    }

    let longestPalindrome = "";
    for (let i = bestStart; i < bestStart + maxLength; i++) {
        longestPalindrome = longestPalindrome + s1.charAt(i);
    }

    console.log("Original String   : " + s1);
    console.log("Max Palindrome Len: " + maxLength);
    console.log("Longest Substring : \"" + longestPalindrome + "\"");
}