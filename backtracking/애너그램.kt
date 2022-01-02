import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var strs = charArrayOf()
    var visited = arrayOf<Int>()
    var selected = arrayOf<Char>()

    fun dfs(k: Int) {
        if (k == strs.size) {
            for (i in strs.indices) {
                bw.write("${selected[i]}")
            }
            bw.write("\n")
        } else {
            // k번째 자리에 대해 중복되는 단어 제거 위한 변수
            var beforeChar = ' '
            for (i in strs.indices) {
                // 같은 자리에 대해 이전에 같은 문자가 들어갔다면 continue
                if (beforeChar == strs[i]) continue
                // 이미 사용한 단어라면 continue
                if (visited[i] == 1) continue
                visited[i] = 1
                selected[k] = strs[i]
                dfs(k + 1)
                visited[i] = 0
                selected[k] = ' '
                // 다음 loop 돌기 전에 이전에 k번째 자리에 넣은 단어 저장
                beforeChar = strs[i]
            }
        }
    }

    repeat(br.readLine().toInt()) {
        strs = br.readLine().toCharArray()
        strs.sort()
        visited = Array(strs.size) { 0 }
        selected = Array(strs.size) { ' ' }
        dfs(0)
    }

    bw.flush()
    bw.close()
    br.close()
}



