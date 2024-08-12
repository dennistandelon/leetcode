/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let count = init;
    const size = nums.length;
    for(let i=0; i < size; i++){
        count = fn(count,nums[i]);
    }

    return count;
};