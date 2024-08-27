/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const arrs = [];
    const len = arr.length;

    let count = 0;

    for(let i = 0; i < len; i+=size){
        const arr2 = [];
        for(let j = 0; i+j < len && j < size; j++){
            arr2[j] = arr[i+j];
        }
        arrs.push(arr2);
    }

    return arrs;
};
