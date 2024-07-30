package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertBase10Test {
    @Test
    fun convertTest() = runBlocking{
        val bytes = arrayOf(0x00, 0xFC, 0xD0, 0x00)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(2u.toUByte(), D5700.memory.read(0u.toUShort()))
        assertEquals(5u.toUByte(), D5700.memory.read(1u.toUShort()))
        assertEquals(2u.toUByte(), D5700.memory.read(2u.toUShort()))
    }

    @Test
    fun convertTensOnlyTest() = runBlocking{
        val bytes = arrayOf(0x00, 0x0F, 0xD0, 0x00)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(0u.toUByte(), D5700.memory.read(0u.toUShort()))
        assertEquals(1u.toUByte(), D5700.memory.read(1u.toUShort()))
        assertEquals(5u.toUByte(), D5700.memory.read(2u.toUShort()))
    }

    @Test
    fun convertOnesOnlyTest() = runBlocking{
        val bytes = arrayOf(0x00, 0x08, 0xD0, 0x00)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(0u.toUByte(), D5700.memory.read(0u.toUShort()))
        assertEquals(0u.toUByte(), D5700.memory.read(1u.toUShort()))
        assertEquals(8u.toUByte(), D5700.memory.read(2u.toUShort()))
    }

    @Test
    fun convertOverwriteTest() = runBlocking{
        val bytes = arrayOf(0x00, 0xFC, 0xD0, 0x00, 0x00, 0x08, 0xD0, 0x00)
        D5700.run(ByteArray(8) {
            bytes[it].toByte()
        })
        delay(8)
        assertEquals(0u.toUByte(), D5700.memory.read(0u.toUShort()))
        assertEquals(0u.toUByte(), D5700.memory.read(1u.toUShort()))
        assertEquals(8u.toUByte(), D5700.memory.read(2u.toUShort()))
    }
}