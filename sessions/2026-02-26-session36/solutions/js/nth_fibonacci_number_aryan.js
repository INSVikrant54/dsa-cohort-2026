// https://www.geeksforgeeks.org/dsa/program-for-nth-fibonacci-number/

function nthFibonacci(n) {
    if (n <= 1) return n
    return nthFibonacci(n - 1) + nthFibonacci(n - 2)
}