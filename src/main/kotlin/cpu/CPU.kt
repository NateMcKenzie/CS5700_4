package cpu

import java.util.*
import kotlin.concurrent.timer

class CPU {
    private val registers = RegisterBank()
    private val parser = Parser(registers)

    private var pc: UShort = 0u
    private lateinit var clock: Timer
    private var timerTrack = 0

    val timer get() = registers.timer
    val address get() = registers.address

    fun start() {
        pc = 0u
        timerTrack = 0
        clock = timer(initialDelay = 0, period = 2) {
            mainLoop()
        }
    }

    private fun stop() {
        clock.cancel()
    }

    private fun mainLoop() {
        var switched = false

        //Read instruction from ROM
        if (!D5700.ROMmode) {
            switched = true
            D5700.switchROMmode()
        }
        val line = Pair(
            D5700.readMemory(pc),
            D5700.readMemory((pc + 1u).toUShort()),
        )
        //Restore memory driver state
        if (switched) D5700.switchROMmode()

        if (line.first == 0u.toUByte() && line.second == 0u.toUByte()) {
            stop()
            return
        }

        val nibbleds = Pair(Nibbled(line.first), Nibbled(line.second))
        val instruction = parser.parse(nibbleds.first.first)
        val newPC = instruction.run(nibbleds, pc)
        pc = newPC
        if (++timerTrack % 8 == 0) {
            decrementTimer()
        }
    }

    fun decrementTimer() {
        if (registers.timer > 0u)
            registers.timer = (registers.timer - 1u).toUByte()
    }

    fun readRegister(address: UByte) = registers.readRegister(address)
}
