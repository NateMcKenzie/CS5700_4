import cpu.CPU
import memory.MemoryDriver

object D5700 {
    val memory = MemoryDriver()
    val cpu = CPU()
    //val keyboard = Keyboard()
    //val screen = Screen()

    fun init(data: ByteArray){
        memory.flashROM(data)
        cpu.start()
    }
}