package memory

class Memory (
    val writable: Boolean = true
){
    private val data = MutableList<UByte>(4096) {0u}

    fun read(address: UByte) : UByte{
        val index = address.toInt()
        return data[index]
    }

    fun write(address: UByte, value: UByte){
        if(writable) {
            val index = address.toInt()
            data[index] = value
        }else {
            throw IllegalAccessError("This memory device is read-only")
        }
    }

    fun flash(data: ByteArray){
        for (i in data.indices){
            this.data[i] = data[i].toUByte()
        }
    }
}
