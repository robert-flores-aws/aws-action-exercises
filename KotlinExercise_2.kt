import java.util.*

fun main(args: Array<String>){

    print("Enter String : ")
    val inputString = readLine().toString()

    var filteredString = inputString.filter { !it.isWhitespace() }.lowercase()

    val conversion = filteredString.toList()
    val  removeDuplicate = conversion.distinct().toSortedSet()

    for (item in removeDuplicate.distinct()){
        println("There are "+ Collections.frequency(conversion, item)+ " - $item")
    }
}