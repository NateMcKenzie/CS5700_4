package cpu

import D5700
import bytesToShort
import shortToBytes
import java.util.Timer
import kotlin.concurrent.timer

class Executive (
    parserReference: Parser
){
    private var pc : UShort = 0u
    private lateinit var clock : Timer
    private val parser = parserReference

    fun start(){
        pc = 0u
        clock = timer(initialDelay = 0, period = 2){
            mainLoop()
        }
    }

    private fun mainLoop(){
        val memory = D5700.memory
        var switched = false

        //Read instruction from ROM
        if(!memory.ROMmode){
            switched = true
            memory.switch()
        }
        val line = Pair(
           memory.read(shortToBytes(pc)),
            memory.read(shortToBytes((pc+1u).toUShort())),
        )
        //Restore memory driver state
        if(switched) memory.switch()

        val nibbleds = Pair(Nibbled(line.first), Nibbled(line.second))
        val instruction = parser.parse(nibbleds.first.nibbles.first)
        val newPC = instruction.run(nibbleds, shortToBytes(pc))
        pc = bytesToShort(newPC)
    }
}