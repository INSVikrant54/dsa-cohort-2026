// https://www.geeksforgeeks.org/dsa/sum-of-natural-numbers-using-recursion/

/**
 * @param {number}
 * @return {number}
 */

// first
function recursion(n, sum = 0) {
    if (n === 0) return sum
    sum += n
    return recursion(n - 1, sum)
}

// second (improved version)

function recursionTwo(n) {
    if (n === 0) return 0
    return n + recursion(n - 1)
}
