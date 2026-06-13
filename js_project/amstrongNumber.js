/* let n= 1634;
let original = n;
let temp = n;
let count = 0;
let result = 0;
while (temp>0){
    temp = Math.floor(temp/10);
    count ++;
}
temp = n;
while (temp>0){
    let lastDigit = temp %10;
    result = result + Math.pow(lastDigit, count);
    temp = Math.floor(temp/10);
}
if (result===original){
    console.log (n+ " is a amstrong Number")
}
else{
    console.log (n+ " is not a Amstrong number")
} */
function isAmstrongNumber(N){
    let original = N;
    let temp = N;
    let count = 0;
    let result = 0;
    while (temp >0){
        temp = Math.floor(temp/10);
        count ++;

    }
    temp = N;
    while (temp>0){
        let lastDigit = temp %10;
        result = result + Math.pow(lastDigit, count);
        temp = Math.floor(temp/10)


    }
    return result===original;
    
}
let N = 1634
if (isAmstrongNumber(N)){
    console.log ((N)+ " is a amstrong number");

}
else {
    console.log ((N)+ " is not Amstrong Number")
}
