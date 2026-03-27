/**
 * @param {number} n
 * @return {string[][]}
 */

function transformBoard(board) {
    const result = []
    for (let item of board) {
        result.push(item.join(''))
    }
    return result
}

var solveNQueens = function (n) {
    const board = []
    for (let i = 0; i < n; i++) {
        board.push(new Array(n).fill('.'))
    }

    const result = []
    function backtrack(board, row, colSet, diagSet, antiDiagSet) {
        if (row === n) result.push(transformBoard(board))

        for (let col = 0; col < n; col++) {
            if (colSet.has(col) || diagSet.has(row - col) || antiDiagSet.has(row + col)) continue

            board[row][col] = 'Q'
            colSet.add(col)
            diagSet.add(row - col)
            antiDiagSet.add(row + col)

            backtrack(board, row + 1, colSet, diagSet, antiDiagSet)

            board[row][col] = '.'
            colSet.delete(col)
            diagSet.delete(row - col)
            antiDiagSet.delete(row + col)
        }
    }
    backtrack(board, 0, new Set(), new Set(), new Set())
    return result
};