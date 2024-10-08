/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    this.curr = init
    this.init = init
    return {
        increment(){
            curr += 1
            return curr;
        },
        reset(){
            curr = init
            return curr
        },
        decrement(){
            curr -= 1
            return curr
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */