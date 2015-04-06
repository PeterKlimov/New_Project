package com.example.pk.new_project.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by PK on 4/2/2015.
 */
public class VoteContract {

    //LOCAL DB CONSTANTS
    public static final boolean DONE=true,NOT_DONE=false, OPEN=true, CLOSE=false;

    public static final String CONTENT_AUTHORITY="com.example.pk.new_project";
    //   content://com.example.pk.new_project
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://"+ CONTENT_AUTHORITY);
    public static final String PATH_GROUPS="groups";
    public static final  String PATH_QUESTIONS="questions";

    public static final class GroupsEntry implements BaseColumns{

        //CONTENT_URI=content://com.example.pk.new_project/groups
        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_GROUPS).build();

        public static final String CONTENT_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+ CONTENT_AUTHORITY+"/"+PATH_GROUPS;
        public static final String CONTENT_ITEM= ContentResolver.CURSOR_ITEM_BASE_TYPE+"/"+ CONTENT_AUTHORITY+"/"+PATH_GROUPS;
        //Table Structure
        public static final String TABLE_NAME="groups";
        public static final String COLUMN_G_NAME="g_name";
        public static final String COLUMN_G_DESCRIPTION="g_description";
        public static final String COLUMN_G_NUM_OF_CLIENTS="g_num_of_clients";
        public static final String COLUMN_G_NUM_OF_QUESTIONS="g_num_of_questions";
        public static final String COLUMN_G_ACTIVITY="g_activity";
        public static final String COLUMN_G_ADMIN_STATUS="g_admin_status";                  // bool
        public static final String COLUMN_G_ADMIN_FIRST_NAME="g_admin_first_name";
        public static final String COLUMN_G_ADMIN_LAST_NAME="g_admin_last_name";

        public  static Uri buildGroupsUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


      }

public  static  final class QuestionsEntry implements BaseColumns{
    public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_QUESTIONS).build();

    public static final String CONTENT_TYPE=ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/"+PATH_QUESTIONS;
    public static final String CONTENT_ITEM_TYPE=ContentResolver.CURSOR_ITEM_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/"+PATH_QUESTIONS;
    public static final String TABLE_NAME="questions";
    //Table Structure
    public static final String COLUMN_Q_QUESTION="q_question";
    public static final String COLUMN_Q_GROUP="group_id";
    public static final String COLUMN_Q_TYPE="q_type";
    public static final String COLUMN_Q_ANSWERS="q_answers";
    public static final String COLUMN_Q_MY_ANSWER="q_my_answer";        // string with options?
    public static final String COLUMN_Q_STATE="q_state";                // bool OPEN/CLOSE
    public static final String COLUMN_Q_COMPLETED="q_completed";        // bool DONE/NOT_DONE
    public static final String COLUMN_Q_OWNER="q_owner";

    public  static Uri buildQuestionsUri(long id){
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }



}








}
