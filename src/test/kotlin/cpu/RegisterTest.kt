package cpu

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RegisterTest {
    @Test
    fun writeReadTest() {
        val bank = RegisterBank()
        for (i in 0..7) {
            bank.writeRegister(i.toUByte(), i.toUByte())
            assertEquals(i.toUByte(), bank.readRegister(i.toUByte()))
        }
    }

    @Test
    fun illegalWriteTest() {
        val bank = RegisterBank()
        assertFailsWith<ArrayIndexOutOfBoundsException> {
            bank.writeRegister(8u.toUByte(), 0u.toUByte())
        }
        assertFailsWith<ArrayIndexOutOfBoundsException> {
            bank.writeRegister(255u.toUByte(), 0u.toUByte())
        }
    }

    @Test
    fun illegalReadTest() {
        val bank = RegisterBank()
        assertFailsWith<ArrayIndexOutOfBoundsException> {
            bank.readRegister(8u.toUByte())
        }
        assertFailsWith<ArrayIndexOutOfBoundsException> {
            bank.readRegister(255u.toUByte())
        }

    }
}