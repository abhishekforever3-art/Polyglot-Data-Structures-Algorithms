   /*  let n=6545;
    let count = 0;
    while(n>0){
        
        count++;
        n=Math.floor(n/10);
    }
    console.log(count); */

    x=6545;
    function digitCount(N){
        
        let count =0;
        while (N>0){
            count++;
            N= Math.floor(N/10);
        }
        return count;
    }
    console.log(digitCount(x));