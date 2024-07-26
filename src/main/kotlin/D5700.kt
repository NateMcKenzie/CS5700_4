import cpu.CPU
import memory.MemoryDriver

object D5700 {
    val memory = MemoryDriver()
    val cpu = CPU()
    //val keyboard = Keyboard()
    //val screen = Screen()

    fun run(data: ByteArray){
        memory.flashROM(data)
        cpu.start()
    }

    fun keyboardRead(){
        TODO("Not implemented yet")
    }

    fun screenWrite(value: Byte, row: Byte, col: Byte){
        TODO("Not implemented yet")
    }
}
