/* function isPerfectNumber(n) {
  let sum = 0;
  
  for (let i = 1; i < n; i++) {
    if (n % i === 0) {
      sum += i;
    }
  }

  if (sum === n && n !== 0) {
    console.log(n + " is a perfect number.");
  } else {
    console.log(n + " is not a perfect number.");
  }
} */

  let n = 134;
  let sum = 0;
  for (let i= 1; i<n ; i++){
    if (n%i ===0){
      sum+= i;
    }
  }
  if (sum === n && n!==0){
    console.log(n+ "is a perfect number");
  } 
  else {
    console.log (n + "is not a perfect number")
  }