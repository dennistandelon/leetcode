/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {

    return {    
        toBe(x){
            if(x !== val) throw 'Not Equal';
            return x === val
        },

        notToBe(x){
            if(x === val) throw 'Equal';
            return x !== val
        }
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */