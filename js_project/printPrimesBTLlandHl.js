let ll = 10;
let hl = 50;

console.log("Prime numbers between " + ll + " and " + hl + ":");


for (let i = ll; i <= hl; i++) {
  if (i <= 1) continue; 

  let isPrime = true;

  
  for (let j = 2; j <= Math.sqrt(i); j++) {
    if (i % j === 0) {
      isPrime = false; 
      break;    
    }
  }
  if (isPrime) {
    console.log(i);
  }
}