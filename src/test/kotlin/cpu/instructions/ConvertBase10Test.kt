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
        assertEquals(2u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 0u.toUByte())))
        assertEquals(5u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 1u.toUByte())))
        assertEquals(2u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 2u.toUByte())))
    }

    @Test
    fun convertTensOnlyTest() = runBlocking{
        val bytes = arrayOf(0x00, 0x0F, 0xD0, 0x00)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(0u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 0u.toUByte())))
        assertEquals(1u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 1u.toUByte())))
        assertEquals(5u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 2u.toUByte())))
    }

    @Test
    fun convertOnesOnlyTest() = runBlocking{
        val bytes = arrayOf(0x00, 0x08, 0xD0, 0x00)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(0u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 0u.toUByte())))
        assertEquals(0u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 1u.toUByte())))
        assertEquals(8u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 2u.toUByte())))
    }

    @Test
    fun convertOverwriteTest() = runBlocking{
        val bytes = arrayOf(0x00, 0xFC, 0xD0, 0x00, 0x00, 0x08, 0xD0, 0x00)
        D5700.run(ByteArray(8) {
            bytes[it].toByte()
        })
        delay(8)
        assertEquals(0u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 0u.toUByte())))
        assertEquals(0u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 1u.toUByte())))
        assertEquals(8u.toUByte(), D5700.memory.read(Pair(0u.toUByte(), 2u.toUByte())))
    }
}