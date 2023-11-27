package vega.odyssey.passpilot

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FastSaveDB"
        private const val TABLE_NAME = "UserData"
        private const val KEY_ID = "id"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
        private const val KEY_SITE = "site"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = ("CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY, " +
                "$KEY_USERNAME TEXT, $KEY_PASSWORD TEXT, $KEY_SITE TEXT)")
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUserData(username: String, password: String, site: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_USERNAME, username)
        contentValues.put(KEY_PASSWORD, password)
        contentValues.put(KEY_SITE, site)
        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return result
    }
}
