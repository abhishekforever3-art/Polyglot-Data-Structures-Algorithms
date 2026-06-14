let text = "A";

console.log("--- Starting Condition ---");
console.log("Initial Text   : " + text);
console.log("--------------------------\n");

console.log("--- Starting Loop (Appending 5 Times) ---");

// JS loops look identical to Java loops
for (let i = 0; i <= 5; i++) {
    text = text + "X";

    console.log("Step " + i + " Text   : " + text);
    console.log("");
}