/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    if(typeof obj === "object"){
        for(var x in obj){
            return false;
        }
    } else if(typeof obj === "array" && obj.length !== 0){
        return false;
    }

    return true;
};