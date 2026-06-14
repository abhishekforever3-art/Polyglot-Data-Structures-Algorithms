let text = "Abhishek";
let startChar = 'b';
let endChar = 'k';

let startIndex = -1;
let endIndex = -1;
let length = text.length;

for (let i = 0; i < length; i++) {
    if (text.charAt(i) === startChar) {
        startIndex = i;
        break; 
    }
}

if (startIndex !== -1) {
    for (let i = startIndex + 1; i < length; i++) {
        if (text.charAt(i) === endChar) {
            endIndex = i;
            break; 
        }
    }
}

if (startIndex === -1 || endIndex === -1) {
    console.log("Error: One or both boundary characters were not found.");
} else {
    let trappedText = "";
    
    for (let i = startIndex + 1; i < endIndex; i++) {
        trappedText = trappedText + text.charAt(i);
    }
    
    console.log("Original Text   : " + text);
    console.log("Start Border    : '" + startChar + "' at index " + startIndex);
    console.log("End Border      : '" + endChar + "' at index " + endIndex);
    console.log("Trapped Segment : \"" + trappedText + "\"");
}