package com.jindvir.blue.datastore

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream


class WriteObjectFile(private val parent: Context) {
    private var fileIn: FileInputStream? = null
    private var fileOut: FileOutputStream? = null
    private var objectIn: ObjectInputStream? = null
    private var objectOut: ObjectOutputStream? = null
    private var outputObject: Any? = null
    private var filePath: String? = null
    fun readObject(fileName: String): Any? {
        try {
            filePath = parent.applicationContext.filesDir.absolutePath + "/" + fileName
            fileIn = FileInputStream(filePath)
            objectIn = ObjectInputStream(fileIn)
            outputObject = objectIn!!.readObject()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } finally {
            if (objectIn != null) {
                try {
                    objectIn!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return outputObject
    }

    fun writeObject(inputObject: Any?, fileName: String) {
        try {
            filePath = parent.applicationContext.filesDir.absolutePath + "/" + fileName
            fileOut = FileOutputStream(filePath)
            objectOut = ObjectOutputStream(fileOut)
            objectOut!!.writeObject(inputObject)
            fileOut!!.fd.sync()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (objectOut != null) {
                try {
                    objectOut!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}