/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    var len = this.length;
    const res = {};
    for(let i=0; i < len; i++){
        var x = fn(this[i]);

        if(res[x] == null){
            res[x] = [this[i]];
        } else{
            res[x].push(this[i]);
        }
    }

    return res;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */