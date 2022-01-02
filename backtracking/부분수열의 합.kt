import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    val nums = arrayListOf<Int>()
    br.readLine().split(" ").map { nums.add(it.toInt()) }
    var count = 0
    if (S == 0) count--

    fun dfs(k: Int, value: Int) {
        if (k == N) {
            if (value == S) count++
        } else {
            dfs(k+1, value)
            dfs(k+1, value + nums[k])
        }
    }

    dfs(0, 0)
    bw.write("$count")
    bw.flush()
    bw.close()
    br.close()
}

