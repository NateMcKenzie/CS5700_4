package memory

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MemoryDriverTest {
    @Test
    fun ramReadWriteTest() {
        val driver = MemoryDriver()
        if (driver.ROMmode) {
            driver.switchROMmode()
        }
        driver.write(0x00u.toUShort(), 0xFu)
        driver.write(0x00FFu.toUShort(), 0x5u)
        assertEquals(0xFu, driver.read(0x00u.toUShort()))
        assertEquals(0x5u, driver.read(0x00FFu.toUShort()))
    }

    @Test
    fun romWriteFailsTest() {
        val driver = MemoryDriver()
        if (!driver.ROMmode) {
            driver.switchROMmode()
        }
        assertFailsWith<IllegalAccessError> {
            driver.write(0x00u.toUShort(), 1u)
        }
    }

    @Test
    fun romFlashReadTest() {
        val driver = MemoryDriver()
        driver.flashROM(ByteArray(10) { it.toByte() })
        if (!driver.ROMmode) {
            driver.switchROMmode()
        }
        for (i in 0..<10) {
            val iByte = i.toUByte()
            assertEquals(iByte, driver.read(iByte.toUShort()))
        }
        for (i in 10..<4096) {
            assertEquals(0u, driver.read(i.toUShort()))
        }
    }

    @Test
    fun switchTest() {
        //Write different data to each memory device
        val driver = MemoryDriver()
        driver.flashROM(ByteArray(10) { it.toByte() })
        if (driver.ROMmode) {
            driver.switchROMmode()
        }
        for (i in 0..<10) {
            driver.write(i.toUShort(), (i * 2).toUByte())
        }

        //Ensure both read separately
        for (i in 0..<10) {
            assertEquals((i * 2).toUByte(), driver.read(i.toUShort()))
        }
        driver.switchROMmode()
        for (i in 0..<10) {
            assertEquals(i.toUByte(), driver.read(i.toUShort()))
        }
    }
}