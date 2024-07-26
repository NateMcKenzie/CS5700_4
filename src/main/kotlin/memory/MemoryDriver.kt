package memory

class MemoryDriver {
    private val ROM = Memory(writable = false)
    private val RAM = Memory(writable = true)
    var ROMmode = false
        private set;


    fun read(address: Pair<UByte, UByte>) : UByte{
        if (ROMmode){
            return ROM.read(address)
        }
        return RAM.read(address)
    }

    fun write(address: Pair<UByte, UByte>, value: UByte){
        if (ROMmode){
            return ROM.write(address, value)
        }
        return RAM.write(address, value)
    }

    fun flashROM(data: ByteArray){
        ROM.flash(data)
    }

    fun switch(){
        ROMmode = !ROMmode
    }
}