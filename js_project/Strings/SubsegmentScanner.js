let s1 = "Abhishek";
let k = 5;
let totallength = s1.length;
let stratIndex = totallength - k;
console.log("Scanning \"" + s1 + "\" with window size K = " + k + ":\n");
if ( k>totallength || k <=0 ){
    console.log("Error: Invalid window length K.");
}
else{
    for (let i = 0; i<stratIndex; i++){
        let s2 = "";
        for (let j =0; j<k; j++){
            s2= s2+ s1.charAt(i+j);
        }
        console.log("Window at Index " + i + ": " + s2);
    }
}
