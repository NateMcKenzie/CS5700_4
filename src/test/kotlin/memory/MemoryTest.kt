package memory

import shortToBytes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MemoryTest {
    @Test
    fun ramReadWriteTest() {
        val ram = Memory(true)
        ram.write(0x00u.toUShort(), 0xFu)
        ram.write(0x00FFu.toUShort(), 0x5u)
        assertEquals(0xFu, ram.read(0x00u.toUShort()))
        assertEquals(0x5u, ram.read(0x00FFu.toUShort()))
    }

    @Test
    fun romWriteFailsTest() {
        val rom = Memory(false)
        assertFailsWith<IllegalAccessError> {
            rom.write(0x00u.toUShort(), 1u)
        }
    }

    @Test
    fun romFlashReadTest() {
        val rom = Memory(false)
        rom.flash(ByteArray(10) { it.toByte() })
        for (i in 0..<10) {
            val iByte = i.toUByte()
            assertEquals(iByte, rom.read(iByte.toUShort()))
        }
        for (i in 10..<4096) {
            assertEquals(0u, rom.read(i.toUShort()))
        }
    }

    @Test
    fun fullyAddressableTest() {
        val ram = Memory(true)
        for (i in 0..<4096) {
            val address = i.toUShort()
            val value = i.toUByte()
            ram.write(address, value)
            assertEquals(value, ram.read(address))
        }
    }
}
