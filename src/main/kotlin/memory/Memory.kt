package memory

class Memory (
    val writable: Boolean = true
){
    private val data = MutableList<UByte>(4096) {0u}

    fun read(address: Byte) : Byte{
        TODO("Not implemented yet")
    }

    fun write(address: Byte, value: Byte){
        TODO("Not implemented yet")
    }

    fun flash(data: ByteArray){
        for (i in data.indices){
            this.data[i] = data[i].toUByte()
        }
    }
}
