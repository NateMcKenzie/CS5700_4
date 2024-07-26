package cpu

import java.util.Timer
import kotlin.concurrent.timer

class Executive (
    parserReference: Parser
){
    private val pc = UByteArray(2) {0u}
    private lateinit var clock : Timer
    private val parser = parserReference

    fun start(){
        clock = timer(initialDelay = 0, period = 2){
            mainLoop()
        }
    }

    private fun mainLoop(){
        TODO("Not implemented yet")

    }
}