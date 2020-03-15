package ru.mnluneva.threadsdrive

import java.io.FileOutputStream

class ThreadA: Thread() {
    override fun run() {
        for(i in 1..100){
            FileOutputStream(textFile, true).bufferedWriter().use {
                it.write("Поток А $i \n")
                if (i == 100 && !isWin){
                    isWin = true
                    it.write("Поток А выиграл \n")
                } else if (i == 100 && isWin) {
                    it.write("Поток А проиграл \n")
                    isWin = false
                }
                it.close()
            }
        }
    }
}