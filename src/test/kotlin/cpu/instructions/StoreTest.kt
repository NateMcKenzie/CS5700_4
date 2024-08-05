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

class StoreTest {
    @Test
    fun storeTest() {
        val registers = RegisterBank()
        val byteCode = Pair(Nibbled( 0x00.toUByte()),Nibbled( 0xff.toUByte()))
        val instruction = Store(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xffu.toUByte(), registers.readRegister(0u.toUByte()))
    }

    @Test
    fun addressTest() = runBlocking {
        val registers =  RegisterBank()
        val byteCode = Pair(Nibbled( 0x07.toUByte()),Nibbled( 0xcd.toUByte()))
        val instruction = Store(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xcdu.toUByte(), registers.readRegister(7u.toUByte()))
    }
}