const fizzBuzz = (counter, arr, msg= '') => {
    
            if(counter === 0)
             return msg; 
    
            let val = checkElement(counter, arr)
    
            if(val)
                msg += counter + ': ' + val + "\n"
    
            return fizzBuzz(counter - 1, arr, msg)
    
    }
    
            const checkElement = (counter, array, msg = '', index = 0) => {
                if(index < array.length){
                    if(array[index] != undefined){
                        if((counter % (index + 1)) === 0) {
                            msg += array[index]
                        }
                    } return checkElement(counter, array, msg, index + 1)
                }else {
                    return msg;
                }
            }
    
            
    
    
    const printValue = [undefined, undefined, 'fizz', undefined, 'buzz', undefined, undefined, 'what']
    console.log(fizzBuzz(100, printValue))

