/* let n = 1645;
let reversed = 0;
while (n>0){
    let lastDigit = n%10;
    reversed = (reversed*10)+lastDigit;
        n=Math.floor(n/10);     
}
console.log(reversed) */

x=1645;
function reverseDigits (N){
    let reversed = 0;
    while (N>0){
        let lastDigit = N%10;
        reversed = (reversed*10)+lastDigit;
        N=Math.floor(N/10);
    }
    return reversed
}
console.log(reverseDigits(x));