import cpu.CPU
import memory.MemoryDriver

object D5700 {
    private lateinit var memory: MemoryDriver
    private lateinit var cpu: CPU
    private val keyboard = Keyboard()
    private val screen = Screen()
    val ROMmode get() = memory.ROMmode

    fun run(data: ByteArray) {
        memory = MemoryDriver(ROMmode = false)
        memory.flashROM(data)
        cpu = CPU()
        cpu.start()
    }

    fun runInject(memory: MemoryDriver, cpu: CPU) {
        this.memory = memory
        this.cpu = cpu
        cpu.start()
    }

    fun readMemory(address: UShort) = memory.read(address)
    fun writeMemory(address: UShort, value: UByte) = memory.write(address, value)
    fun switchROMmode() = memory.switchROMmode()
    fun readKeyboard() = keyboard.read()
    fun writeScreen(value: UByte, row: UByte, col: UByte) = screen.write(value, row, col)
}
