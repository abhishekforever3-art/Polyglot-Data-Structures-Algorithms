let n = 100; 

console.log("Perfect numbers between 1 and " + n + ":");


for (let i = 1; i <= n; i++) {
  let sum = 0;

  
  for (let j = 1; j < i; j++) {
    if (i % j === 0) {
      sum += j; 
    }
  }

  
  if (sum === i && i !== 0) {
    console.log(i + " is a perfect number");
  }
}