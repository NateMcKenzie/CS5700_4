package cpu

import cpu.instructions.*
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

class ParserTest {
    private val registers = RegisterBank()
    private val parser = Parser(registers)

    @Test
    fun storeTest(){
        val returned = parser.parse(0u.toUByte())
        assertIs<Store>(returned)
    }

    @Test
    fun addTest(){
        val returned = parser.parse(1u.toUByte())
        assertIs<Add>(returned)
    }

    @Test
    fun subtractTest(){
        val returned = parser.parse(2u.toUByte())
        assertIs<Subtract>(returned)
    }

    @Test
    fun readTest(){
        val returned = parser.parse(3u.toUByte())
        assertIs<Read>(returned)
    }

    @Test
    fun writeTest(){
        val returned = parser.parse(4u.toUByte())
        assertIs<Write>(returned)
    }

    @Test
    fun jumpTest(){
        val returned = parser.parse(5u.toUByte())
        assertIs<Jump>(returned)
    }

    @Test
    fun readKeyboardTest(){
        val returned = parser.parse(6u.toUByte())
        assertIs<ReadKeyboard>(returned)
    }

    @Test
    fun switchMemoryTest(){
        val returned = parser.parse(7u.toUByte())
        assertIs<SwitchMemory>(returned)
    }

    @Test
    fun skipEqualTest(){
        val returned = parser.parse(8u.toUByte())
        assertIs<SkipEqual>(returned)
    }

    @Test
    fun skipNotEqualTest(){
        val returned = parser.parse(9u.toUByte())
        assertIs<SkipNotEqual>(returned)
    }

    @Test
    fun setATest(){
        val returned = parser.parse(10u.toUByte())
        assertIs<SetA>(returned)
    }

    @Test
    fun setTTest(){
        val returned = parser.parse(11u.toUByte())
        assertIs<SetT>(returned)
    }

    @Test
    fun readTTest(){
        val returned = parser.parse(12u.toUByte())
        assertIs<ReadT>(returned)
    }

    @Test
    fun convertBase10Test(){
        val returned = parser.parse(13u.toUByte())
        //assertIs<ConvertBase10>(returned)
    }

    @Test
    fun convertASCIITest(){
        val returned = parser.parse(14u.toUByte())
        //assertIs<ConvertASCII>(returned)
    }

    @Test
    fun drawTest(){
        val returned = parser.parse(15u.toUByte())
        //assertIs<Draw>(returned)
    }

    @Test
    fun invalidTest() {
        assertFailsWith<NotImplementedError>{
            parser.parse(16u.toUByte())
        }
        assertFailsWith<NotImplementedError>{
            parser.parse(32u.toUByte())
        }
        assertFailsWith<NotImplementedError>{
            parser.parse(255u.toUByte())
        }
    }
}