package memory

class Memory(
    val writable: Boolean = true,
    size: Int = 4096,
) {
    private val data = MutableList<UByte>(size) { 0u }

    fun read(address: UShort): UByte {
        val index = address.toInt()
        return data[index]
    }

    fun write(address: UShort, value: UByte) {
        if (writable) {
            val index = address.toInt()
            data[index] = value
        } else {
            throw IllegalAccessError("This memory device is read-only")
        }
    }

    fun flash(data: ByteArray) {
        for (i in data.indices) {
            this.data[i] = data[i].toUByte()
        }
    }
}
