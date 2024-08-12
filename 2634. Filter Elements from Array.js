/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let size = arr.length;
    const res = [];
    for(let i=0; i < size; i++){
        if(fn(arr[i],i)){
            res.push(arr[i]);
        }
    }

    return res;
};