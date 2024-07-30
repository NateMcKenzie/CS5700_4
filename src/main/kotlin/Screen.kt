import memory.Memory

class Screen {
    private val memory = Memory(writable = true, size = 64)

    fun write(value: UByte, row: UByte, col: UByte){
        memory.write((row*8u + col).toUShort(), value)
        printScreen()
    }

    private fun printScreen(){
        println("============")
        for (row in 0..7) {
            print(" [")
            for (col in 0..7) {
                val item = memory.read((row*8 + col).toUShort())
                if(item == 0u.toUByte()) print(" ")
                else print(Char(item.toInt()))
            }
            println("]")
        }
    }
}
