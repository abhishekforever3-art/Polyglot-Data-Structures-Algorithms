/* let N= 1645;
let sum = 0;
while(N>0){
    let lastDigit = N%10;
    sum= sum + lastDigit;
    N= Math.floor(N/10);
}
console.log(sum); */

x=1645
function sumOfDigits (N){
    let sum = 0;
    while(N>0){
        let lastDigit = N%10;
        sum = sum+ lastDigit;
        N= Math.floor(N/10);
    }
    return sum;
}
console.log(sumOfDigits(x));