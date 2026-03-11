// not optimized

var subsets = function (nums) {
    let result = []

    function explore(arr, i, temp) {
        if (i === arr.length) {
            let sum = temp.reduce((acc, curr) => acc + curr, 0)
            result.push(sum)
            return
        }
        temp.push(arr[i])
        explore(arr, i + 1, temp)
        temp.pop()
        explore(arr, i + 1, temp)
    }
    explore(nums, 0, [])
    result.sort((a, b) => a - b)
    return result
};


// optimized
var subsets = function (nums) {
    let result = []

    function explore(i, sum) {
        if (i === nums.length) {
            result.push(sum)
            return
        }

        explore(i + 1, sum + nums[i])
        explore(i + 1, sum)
    }

    explore(0, 0)

    result.sort((a, b) => a - b)

    return result
};