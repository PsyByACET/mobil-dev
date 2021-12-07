package com.example.myapplication
interface Command {
    fun execute()
}

class OnCommand(private val ce: ConsumerElectronics) : Command {
    override fun execute() {
        ce.on()
    }
}

class MuteAllCommand(internal var ceList: List<ConsumerElectronics>) : Command {
    override fun execute() {
        for (ce in ceList) {
            ce.mute()
        }
    }
}

interface ConsumerElectronics {
    fun on()
    fun mute()
}

class Television : ConsumerElectronics {

    override fun on() {
        println("Television is on!")
    }

    override fun mute() {
        println("Television is muted!")
    }
}

class SoundSystem : ConsumerElectronics {

    override fun on() {
        println("Sound system is on!")
    }
    override fun mute() {
        println("Sound system is muted!")
    }
}

class PC : ConsumerElectronics {

    override fun on() {
        println("PC is on!")
    }
    override fun mute() {
        println("PC is muted!")
    }
}

class Button(var c: Command) {

    fun click() {
        c.execute()
    }
}

class UniversalRemote {

    fun getActiveDevice() : ConsumerElectronics{
        val tv = Television()
        return tv
    }
}

fun main(args: Array<String>) {

    val ce = UniversalRemote.getActiveDevice()
    val onCommand = OnCommand(ce)
    val onButton = Button(onCommand)
    onButton.click()

    val tv = Television()
    val ss = SoundSystem()
    val pc = PC()
    val all = ArrayList<ConsumerElectronics>()
    all.add(tv)
    all.add(ss)
    val muteAll = MuteAllCommand(all)
    val muteAllButton = Button(muteAll)
    muteAllButton.click()
}

//Команда — это поведенческий паттерн проектирования, который превращает запросы в объекты, позволяя передавать 
//их как аргументы при вызове методов, ставить запросы в очередь, логировать их, а также поддерживать отмену операций.