/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    newArr = []
    for(let i in arr){
        newArr.push(fn(arr[i], new Number(i)));
    }
    return newArr;
};