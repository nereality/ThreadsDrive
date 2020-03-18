package ru.mnluneva.threadsdrive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.File

@Volatile lateinit var textFile: File
var isWin: DriveAtomicBoolean = DriveAtomicBoolean(false)

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startButton = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            textFile = FilesHelper.initFile(this@MainActivity)
            startDrive()
        }
    }

    private fun startDrive() {
        val threadA = ThreadA()
        val threadB = ThreadB()
        threadA.start()
        threadB.start()
    }
}

