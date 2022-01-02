import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    var isFinished = false
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val board = Array<MutableList<Int>>(9) { mutableListOf() }

    for (i in 0 until 9) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    }

    fun valid(i: Int, j: Int, num: Int): Boolean {
        // 행에 대해 겹치는 수 확인
        for (col in 0 until 9) {
            if (board[i][col] == num) return false
        }

        // 열에 대해 겹치는 수 확인
        for (row in 0 until 9) {
            if (board[row][j] == num) return false
        }

        // 3x3에 대해 겹치는 수 확인
        val startI = i - (i % 3)
        val startJ = j - (j % 3)
        for (row in startI until startI+3) {
            for (col in startJ until startJ+3) {
                if (board[row][col] == num) return false
            }
        }
        return true
    }

    fun dfs(i: Int, j: Int) {
        var newI = i
        var newJ = j
        if (j >= 9) {
            newI ++
            newJ = 0
        }
        if (newI >= 9) {
            for (k in 0 until 9) {
                for (l in 0 until 9) {
                    bw.write("${board[k][l]} ")
                }
                bw.write("\n")
            }
            isFinished = true
            return
        }

        // 현 위치가 0이 아닐 경우 바로 다음 dfs 수행
        if (board[newI][newJ] != 0) {
            dfs(newI, newJ+1)
        } else {
            // 처음 위치부터 1~9까지 모두 넣어보며 bfs 수행
            for (num in 1..9) {
                // 해당 값이 invalid라면 continue
                if (!valid(newI, newJ, num)) continue

                // valid라면 해당 값 넣음
                board[newI][newJ] = num
                // 다음 칸으로 이동
                dfs(newI, newJ+1)
                // 값 찾으면 종료
                if (isFinished) return
                // 다음 칸에서 답을 찾지 못했다면 다시 값 되돌려놓음
                board[newI][newJ] = 0
            }
        }
    }

    dfs(0, 0)

    bw.flush()
    br.close()
    bw.close()
}
