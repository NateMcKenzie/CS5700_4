import cpu.CPU
import memory.MemoryDriver

object D5700 {
    lateinit var memory: MemoryDriver
    lateinit var cpu: CPU
    val keyboard = Keyboard()
    //val screen = Screen()

    fun run(data: ByteArray, ROMmode: Boolean = false) {
        memory = MemoryDriver(ROMmode = ROMmode)
        cpu = CPU()
        memory.flashROM(data)
        cpu.start()
    }

    fun screenWrite(value: Byte, row: Byte, col: Byte) {
        TODO("Not implemented yet")
    }
}
