import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val visited = Array(N+1) { 0 }
    val selected = Array(N) { 0 }

    fun dfs(k: Int) {
        if (k >= N) {
            for (i in selected.indices) bw.write("${selected[i]} ")
            bw.write("\n")
            return
        }

        for (i in 1..N) {
            if (visited[i] == 1) continue
            selected[k] = i
            visited[i] = 1
            dfs(k+1)
            selected[k] = 0
            visited[i] = 0
        }
    }

    dfs(0)
    bw.flush()
    bw.close()
    br.close()
}
