package com.example.pk.new_project.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.pk.new_project.data.VoteContract.GroupsEntry;
import com.example.pk.new_project.data.VoteContract.QuestionsEntry;

/**
 * Created by PK on 4/2/2015.
 * manage local DB
 */
public class VoteDbHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    static  final String DATABASE_NAME="vote.db";

    public VoteDbHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_GROUPS_TABLE="CREATE TABLE "+ GroupsEntry.TABLE_NAME+" ("+
                GroupsEntry._ID+ " INTEGER PRIMARY KEY, "+
                GroupsEntry.COLUMN_G_NAME+ " TEXT UNIQUE NOT NULL, "+
                GroupsEntry.COLUMN_G_DESCRIPTION+ " TEXT, "+
                GroupsEntry.COLUMN_G_NUM_OF_CLIENTS+ " INTEGER NOT NULL, "+
                GroupsEntry.COLUMN_G_NUM_OF_QUESTIONS+ " INTEGER, "+
                GroupsEntry.COLUMN_G_ACTIVITY+ " INTEGER, "+
                GroupsEntry.COLUMN_G_ADMIN_STATUS+ " INTEGER NOT NULL, "+
                GroupsEntry.COLUMN_G_ADMIN_FIRST_NAME+ " TEXT, "+
                GroupsEntry.COLUMN_G_ADMIN_LAST_NAME+ " TEXT, " +");";
        //Todo check autoincrement key after delete
        final String SQL_CREATE_QUESTIONS_TABLE="CREATE TABLE "+ QuestionsEntry.TABLE_NAME+" ("+
                QuestionsEntry._ID+ " INTEGER PRIMARY KEY, "+
                QuestionsEntry.COLUMN_Q_GROUP+ " INTEGER NOT NULL, "+
                QuestionsEntry.COLUMN_Q_QUESTION+ " TEXT NOT NULL, "+
                QuestionsEntry.COLUMN_Q_TYPE+ " INTEGER NOT NULL, "+
                QuestionsEntry.COLUMN_Q_ANSWERS+ " TEXT, "+
                QuestionsEntry.COLUMN_Q_MY_ANSWER+ " TEXT, "+
                QuestionsEntry.COLUMN_Q_STATE+ " INTEGER NOT NULL, "+
                QuestionsEntry.COLUMN_Q_COMPLETED+ " INTEGER NOT NULL, "+
                QuestionsEntry.COLUMN_Q_OWNER+ " TEXT, "+
                "FOREIGN KEY ("+QuestionsEntry.COLUMN_Q_GROUP+") REFERENCES "+
                GroupsEntry.TABLE_NAME+" ("+ GroupsEntry._ID+") "+");";
        sqLiteDatabase.execSQL(SQL_CREATE_GROUPS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_QUESTIONS_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+GroupsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+QuestionsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
