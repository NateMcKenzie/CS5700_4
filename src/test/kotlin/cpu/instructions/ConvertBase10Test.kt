package cpu.instructions

import D5700
import cpu.CPU
import cpu.Nibbled
import cpu.RegisterBank
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertBase10Test {
    @Test
    fun convertTest() = runBlocking{
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0xFC, 0xD0, 0x00)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(4)
        assertEquals(2u.toUByte(), memory.read(0u.toUShort()))
        assertEquals(5u.toUByte(), memory.read(1u.toUShort()))
        assertEquals(2u.toUByte(), memory.read(2u.toUShort()))
    }

    @Test
    fun convertTensOnlyTest() = runBlocking{
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x0F, 0xD0, 0x00)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(4)
        assertEquals(0u.toUByte(), memory.read(0u.toUShort()))
        assertEquals(1u.toUByte(), memory.read(1u.toUShort()))
        assertEquals(5u.toUByte(), memory.read(2u.toUShort()))
    }

    @Test
    fun convertOnesOnlyTest() = runBlocking{
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x08, 0xD0, 0x00)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(4)
        assertEquals(0u.toUByte(), memory.read(0u.toUShort()))
        assertEquals(0u.toUByte(), memory.read(1u.toUShort()))
        assertEquals(8u.toUByte(), memory.read(2u.toUShort()))
    }

    @Test
    fun convertOverwriteTest() = runBlocking{
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0xFC, 0xD0, 0x00, 0x00, 0x08, 0xD0, 0x00)
        memory.flashROM(ByteArray(8) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(8)
        assertEquals(0u.toUByte(), memory.read(0u.toUShort()))
        assertEquals(0u.toUByte(), memory.read(1u.toUShort()))
        assertEquals(8u.toUByte(), memory.read(2u.toUShort()))
    }
}