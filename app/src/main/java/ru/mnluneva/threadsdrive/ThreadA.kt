package ru.mnluneva.threadsdrive

import java.io.FileWriter

class ThreadA: Thread() {
    override fun run() {
        name = "Поток А"
        for(i in 1..100){
            FileWriter(textFile, true).use {
                it.write("$name $i \n")
                val resultValue = isWin.compareAndSet(i, expect = false, update = true)
                if(!resultValue.isNullOrEmpty()){
                    it.write("$name $resultValue \n")
                }
                it.close()
            }
        }
    }
}
