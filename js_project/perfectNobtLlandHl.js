    let ll = 10;
    let hl = 30;
    for (let i=ll; i<=hl; i++){
        let sum = 0;

        for (let j=1; j<i; j++){
            if(i%j==0){
                sum+=j;
            }
        }
        if (sum===i && i !=0){
            console.log(i+ " is Perfect Number")
        }

        
    }
