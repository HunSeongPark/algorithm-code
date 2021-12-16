import java.util.*
import kotlin.collections.ArrayList

var v = 0
var e = 0
fun main() = with(Scanner(System.`in`)) {
    v = nextInt()
    e = nextInt()

    val edges = arrayListOf<Edge>()

    for (i in 0 until e) {
        edges.add(Edge(nextInt(), nextInt(), nextInt()))
    }

    Kruskal().kruskalFun(edges)
}


data class Edge(
    val U: Int,
    val V: Int,
    val weight: Int,
) : Comparable<Edge> {

    override fun compareTo(other: Edge): Int {
        return weight - other.weight
    }
}

class Kruskal {
    private val parent = Array(v+1) { 0 }
    private val rank = Array(v+1) { 0 }

    private fun initVertex(vertex: Int) {
        parent[vertex] = vertex
    }

    private fun find(vertex: Int): Int {

        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex])
        }
        return parent[vertex]
    }

    private fun union(u: Int, v: Int) {
        val uRoot = find(u)
        val vRoot = find(v)

        if (rank[uRoot] > rank[vRoot]) {
            parent[vRoot] = uRoot
        } else {
            parent[uRoot] = vRoot
            if (rank[uRoot] == rank[vRoot]) {
                rank[vRoot] = rank[vRoot] + 1
            }
        }
    }

    fun kruskalFun(edges: ArrayList<Edge>) {

        var result = 0
        var currentEdge: Edge

        for (i in 1..v) {
            initVertex(i)
        }

        edges.sort()

        for (i in edges.indices) {
            currentEdge = edges[i]

            if (find(currentEdge.U) != find(currentEdge.V)) {
                union(currentEdge.U, currentEdge.V)
                result += currentEdge.weight
            }
        }
        println(result)
    }
}