import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val stat = Array<Array<Int>>(11) { emptyArray() }
    val selected = Array(11) { 0 }
    var max = Int.MIN_VALUE

    val N = br.readLine().toInt()

    fun dfs(k: Int, sum: Int) {
        if (k >= 11) {
            max = max(max, sum)
            return
        }

        var nonZero = 0
        for (i in 0 until 11) {
            // 선수에 해당하는 경우의 수를 모두 찾았다면 재귀 탈출
            if (nonZero >= 5) return
            // 이미 선발된 포지션이거나 적합하지 않은 포지션일 경우 continue
            if (selected[i] == 1 || stat[k][i] == 0) continue
            // 적합한 포지션인 경우 nonZero count ++
            if (stat[k][i] != 0) nonZero ++
            selected[i] = 1
            dfs(k + 1, sum + stat[k][i])
            selected[i] = 0
        }
    }

    repeat(N) {
        max = Int.MIN_VALUE
        for (i in 0 until 11) {
            stat[i] = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        }
        dfs(0, 0)
        bw.write(max.toString() + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}
