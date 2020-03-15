package ru.mnluneva.threadsdrive

import java.io.FileOutputStream

class ThreadB: Thread() {
    override fun run() {
        for(i in 1..100){
            FileOutputStream(textFile, true).bufferedWriter().use {
                it.write("Поток Б $i \n")
                if (i == 100 && !isWin){
                    isWin = true
                    it.write("Поток Б выиграл \n")
                } else if (i == 100 && isWin) {
                    it.write("Поток Б проиграл \n")
                    isWin = false
                }
                it.close()
            }
        }
    }
}