package ru.mnluneva.threadsdrive

import android.content.Context
import android.util.Log
import java.io.File

class FilesHelper {

    companion object {

        fun initFile(context: Context) : File {
            val directory = File(context.applicationInfo.dataDir)
            val fileName =  "data_${System.currentTimeMillis()}.txt"
            var file = File(directory, fileName)
            if (file.exists()) {
                if (deleteFile(directory, fileName)) {
                    file = File(directory, fileName)
                    return file
                }
                else
                    Log.d("DelFile", "Can't delete file - $fileName")
            } else {
                file = File(directory, fileName)
                return file
            }
            return file
        }

        private fun deleteFile(directory: File, fileName: String): Boolean {
            if (directory.isDirectory) {
                for (file in directory.listFiles()!!) {
                    if (file.name.contains(fileName)) {
                        if (file.isFile) {
                            if (file.exists()) {
                                return file.delete()
                            }
                        }
                    }
                }
            }
            return false
        }

    }
}