class ItemList (var name: String, var quantity: Int){
    fun addStock(stock: Int){
        quantity += stock
    }
}