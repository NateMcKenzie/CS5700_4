package memory

class MemoryDriver(ROMmode: Boolean = false) {
    private val ROM = Memory(writable = false)
    private val RAM = Memory(writable = true)
    var ROMmode = ROMmode
        private set;

    fun read(address: UShort): UByte {
        if (ROMmode) {
            return ROM.read(address)
        }
        return RAM.read(address)
    }

    fun write(address: UShort, value: UByte) {
        if (ROMmode) {
            return ROM.write(address, value)
        }
        return RAM.write(address, value)
    }

    fun flashROM(data: ByteArray) {
        ROM.flash(data)
    }

    fun switch() {
        ROMmode = !ROMmode
    }
}
