package memory

import shortToBytes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MemoryTest {
    @Test
    fun ramReadWriteTest() {
        val ram = Memory(true)
        ram.write(Pair(0u, 0u), 0xFu)
        ram.write(Pair(0u, 0xFFu), 0x5u)
        assertEquals(0xFu, ram.read(Pair(0u, 0u)))
        assertEquals(0x5u, ram.read(Pair(0u, 0xFFu)))
    }

    @Test
    fun romWriteFailsTest() {
        val rom = Memory(false)
        assertFailsWith<IllegalAccessError> {
            rom.write(Pair(0u, 0u), 1u)
        }
    }

    @Test
    fun romFlashReadTest() {
        val rom = Memory(false)
        rom.flash(ByteArray(10) { it.toByte() })
        for (i in 0..<10) {
            val iByte = i.toUByte()
            assertEquals(iByte, rom.read(Pair(0u, iByte)))
        }
        for (i in 10..<4096) {
            assertEquals(0u, rom.read(shortToBytes(i.toUShort())))
        }
    }

    @Test
    fun fullyAddressableTest() {
        val ram = Memory(true)
        for (i in 0..<4096) {
            val address = shortToBytes(i.toUShort())
            val value = i.toUByte()
            ram.write(address, value)
            assertEquals(value, ram.read(address))
        }
    }
}
