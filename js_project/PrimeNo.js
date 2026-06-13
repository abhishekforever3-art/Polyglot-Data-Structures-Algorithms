/* 
let n = 29; 
let isPrime = true;

if (n <= 1) {
  isPrime = false; 
} else {
  
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      isPrime = false; 
      break;           
    }
  }
}
if (isPrime) {
  console.log(n + " is a prime number.");
} else {
  console.log(n + " is NOT a prime number.");
} */

  
function isPrimeNumber(n) {
  if (n <= 1) {
    return false; 
  }
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      return false; 
    }
  }

  return true; 
}

let testNum1 = 29;
let testNum2 = 15;

console.log(testNum1 + " is prime? " + isPrimeNumber(testNum1)); // Returns true
console.log(testNum2 + " is prime? " + isPrimeNumber(testNum2)); // Returns false
  