package oop
 class FakePrinter : Printer {
    val printedList = mutableListOf<String>()
    override fun print(text: String) {
        printedList.add(text)
    }
}