var TimeLimitedCache = function() {
    this.dict = {}
    this.timeout = {}
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    let result = false
    if(this.dict[key]){
        result =  true
    } 

    this.dict[key] = value

    if(this.timeout[key]) {
        clearTimeout(this.timeout[key])
    }

    this.timeout[key] = setTimeout(()=>{
        this.dict[key] = null
        }, duration)

    return result
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if(this.dict[key]){
        return this.dict[key]
    }

    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let count = 0;

    for(let key in this.dict){
        if(this.dict[key] != null){
            count++;
        }
    }

    return count;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */