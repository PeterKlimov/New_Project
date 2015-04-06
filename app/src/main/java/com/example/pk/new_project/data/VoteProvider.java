package com.example.pk.new_project.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.example.pk.new_project.data.VoteContract.GroupsEntry;
import com.example.pk.new_project.data.VoteContract.QuestionsEntry;

/**
 * Created by PK on 4/2/2015.
 */
public class VoteProvider extends ContentProvider {

    private VoteDbHelper mOpenHelper;

    static private final String ACTIVE_QUESTION_COUNTER = "( SELECT group_id, COUNT(_id) AS num_of_questions " +
                                                    "FROM questions " +
                                                    "WHERE q_state=1 AND q_completed=0 " +
                                                    "GROUP BY group_id )";

    private  static  final SQLiteQueryBuilder sGroupsQueryBuilder;

    static {
        sGroupsQueryBuilder = new SQLiteQueryBuilder();
        sGroupsQueryBuilder.setTables(
                GroupsEntry.TABLE_NAME + " LEFT OUTER JOIN " + ACTIVE_QUESTION_COUNTER +
                        " ON " + GroupsEntry.TABLE_NAME +
                        "." + GroupsEntry._ID +
                        "=" + QuestionsEntry.TABLE_NAME +
                        "." + QuestionsEntry.COLUMN_Q_GROUP);
    }

    private Cursor getGroupsWithActiveQuestions(Uri uri, String[] projection, String sortOrder){
        return sGroupsQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                projection)
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
