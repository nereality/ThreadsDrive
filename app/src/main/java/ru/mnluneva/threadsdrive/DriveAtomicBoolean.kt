package ru.mnluneva.threadsdrive

import java.util.concurrent.atomic.AtomicBoolean

class DriveAtomicBoolean(initialValue: Boolean): AtomicBoolean(initialValue) {
    fun compareAndSet(iteration: Int, expect: Boolean, update: Boolean): String? {
        return if(iteration == 100){
            if(super.compareAndSet(expect, update)) "выиграл"
            else "проиграл"
        }
        else null
    }
}
