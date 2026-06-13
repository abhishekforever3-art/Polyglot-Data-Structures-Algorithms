/* let num = 131;
let temp = num;


let digitCount = 0;
let countTemp = num;
while (countTemp > 0) {
    digitCount++;
    countTemp = Math.floor(countTemp / 10);
}

let isCircularPrime = true;


for (let i = 0; i < digitCount; i++) {
    
   
    let isCurrentPrime = true;
    if (temp <= 1) {
        isCurrentPrime = false;
    } else {
        for (let j = 2; j <= Math.sqrt(temp); j++) {
            if (temp % j === 0) {
                isCurrentPrime = false;
                break; 
            }
        }
    }

   
    if (!isCurrentPrime) {
        isCircularPrime = false;
        break;
    }

   
    let lastDigit = temp % 10;
    let remainingNum = Math.floor(temp / 10);
    
    
    let currentDigitCount = 0;
    let rotationCountTemp = temp;
    while (rotationCountTemp > 0) {
        currentDigitCount++;
        rotationCountTemp = Math.floor(rotationCountTemp / 10);
    }

    
    temp = (lastDigit * Math.pow(10, currentDigitCount - 1)) + remainingNum;
}


if (isCircularPrime) {
    console.log(num + " is a Circular Prime.");
} else {
    console.log(num + " is NOT a Circular Prime.");
} */

    
function isPrime(n) {
  if (n <= 1) return false;
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) return false;
  }
  return true;
}


function getDigitCount(n) {
  let count = 0;
  while (n > 0) {
    count++;
    n = Math.floor(n / 10);
  }
  return count;
}


function rotateDigits(n) {
  let count = getDigitCount(n);
  let lastDigit = n % 10;
  let remainingNum = Math.floor(n / 10);
  
  return (lastDigit * Math.pow(10, count - 1)) + remainingNum;
}


function isCircularPrime(n) {
  let temp = n;
  let count = getDigitCount(n);

  for (let i = 0; i < count; i++) {
    if (!isPrime(temp)) {
      return false; 
    }
    temp = rotateDigits(temp); 
  }
  return true;
}


let num = 131;

if (isCircularPrime(num)) {
  console.log(num + " is a Circular Prime.");
} else {
  console.log(num + " is NOT a Circular Prime.");
}