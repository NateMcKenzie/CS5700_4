package memory

class MemoryDriver {
    private val ROM = Memory(writable = false)
    private val RAM = Memory(writable = true)
    var ROMmode = false
        private set;


    fun read(address: Byte) : Byte{
        TODO("Not implemented yet")
    }

    fun write(address: Byte, value: Byte){
        TODO("Not implemented yet")
    }

    fun flashROM(data: ByteArray){
        ROM.flash(data)
    }

    fun switch(){
        ROMmode = !ROMmode
    }
}