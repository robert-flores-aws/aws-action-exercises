import java.util.*
import kotlin.collections.ArrayList

class InventoryManagement {

    private var inventory = arrayListOf(ItemList("Paper",12),ItemList("Pen",10),ItemList("Pencil",15))

    private fun addingProduct(){
        print("Item Name : ")
        val itemName = readLine()
        print("Item Quantity : ")
        val itemQuantity = readLine()
        val newItem = ItemList(itemName.toString(),itemQuantity!!.toInt())
        if (!findProduct(itemName.toString())){
            inventory.add(newItem)
            println("Item was successfully added to the inventory!")
        } else{
            println("Item already exists in the inventory!")
        }
        println("===========================")
    }

    private fun modifyingProductDisplay(itemName: String, inventory: ArrayList<ItemList>): Int {
        for ((index, item) in inventory.withIndex()) {
            if (item.name == itemName) {
                return index
            }
        }
        return -1
    }

    private fun modifyingProduct(){
        print("Item Name : ")
        val itemName = readLine()
        var index = modifyingProductDisplay(itemName.toString(), inventory)
        if (index >= 0){
            print("Input additional quantity : ")
            val quantity = readLine()
            inventory[index].addStock(quantity!!.toInt())
            println("Item successfully updated!")
        } else{
            println("Item not found!")
        }
        println("===========================")
    }

    private fun deletingProduct(){
        print("Item Name : ")
        val itemName = readLine().toString()
        if (findProduct(itemName)){
            inventory.removeIf { it.name == itemName }
            println("Item successfully deleted!")
        } else{
            println("Item not found!")
        }
        println("===========================")
    }

    private fun viewProduct(){
        println("===========================")
        println("LIST OF ALL PRODUCTS:")
        for (item in inventory){
            println("${item.name} : ${item.quantity} pieces")
        }
        println("===========================")
    }

    private fun findProduct(name: String): Boolean{
        for (item in inventory){
            if (item.name == name)
                return true
        }
        return false
    }

    fun menu(){
        do {
            println("===========================")
            println("INVENTORY MANAGEMENT SYSTEM")
            println("===========================")
            println("[1] - Add New Product")
            println("[2] - Modify Product")
            println("[3] - Delete Product")
            println("[4] - View All Product")
            println("[5] - Exit")
            println("===========================")
            print("Select Operation : ")
            val choice: String? = readLine()

            when (choice) {
                "1" -> addingProduct()
                "2" -> modifyingProduct()
                "3" -> deletingProduct()
                "4" -> viewProduct()
                "5" -> System.exit(0);
                else -> println("ERROR: Incorrect Operation Input!")
            }

            print("Do you want to exit the system (Y/N) : ")
            val exit: String? = readLine()?.lowercase()
        }

        while (exit.equals("n"))
        println("ERROR: Incorrect Input! System exit!")
    }
}

