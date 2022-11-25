// Function to check string is palindrome or not
fun checkPalindrome(inputStr: String): Boolean {

    // Reverse the string and remove white spaces
    val original = StringBuilder(inputStr).toString().filter { !it.isWhitespace() }

    // Comparing of reverse and input string
    return original.equals(original.reversed(), ignoreCase = true)
}

fun main() {

    // Input String or Phrase
    print("Enter String : ")
    val inputString: String = readLine().toString()

    //Call function to check String
    if (checkPalindrome(inputString)) {
        println("$inputString is a Palindrome")
    } else {
        println("$inputString is not a Palindrome")
    }
}