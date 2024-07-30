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
    private var timerTrack = 0

    fun start(){
        pc = 0u
        timerTrack = 0
        clock = timer(initialDelay = 0, period = 2){
            mainLoop()
        }
    }

    fun stop(){
        clock.cancel()
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

        if(line.first == 0u.toUByte() && line.second == 0u.toUByte()){
            stop()
            return
        }

        val nibbleds = Pair(Nibbled(line.first), Nibbled(line.second))
        val instruction = parser.parse(nibbleds.first.first)
        val newPC = instruction.run(nibbleds, shortToBytes(pc))
        pc = bytesToShort(newPC)
        if(++timerTrack %8 == 0){
            D5700.cpu.decrementTimer()
        }
    }
}