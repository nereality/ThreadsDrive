package ru.mnluneva.threadsdrive

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

class PermissionManager {

    companion object {

        fun checkRunTimePermission(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val activity = context as MainActivity
                activity.requestPermissions(permissionArrays, MY_PERMISSIONS_REQUEST)
            } else { }
        }

        fun checkPermission(context: Context): Boolean {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    return true
                }
            } else {
                return true
            }

            return false
        }

        private val permissionArrays = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE)

        const val MY_PERMISSIONS_REQUEST = 1
    }
}