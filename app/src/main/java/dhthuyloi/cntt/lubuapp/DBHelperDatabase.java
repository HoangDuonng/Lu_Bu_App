package dhthuyloi.cntt.lubuapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "managetasks.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_TASK = "tasks";
    private static final String TABLE_SUBTASK = "subtasks";
    private static final String TABLE_LOGIN = "login";
    public DBHelperDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Hàm chỉ chạy một lần khi khởi tạo lần đầu tiên để tạo bảng và chèn dữ liệu mẫu
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTasksTable = "CREATE TABLE " + TABLE_TASK + "(" +
                "TaskID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TitleTask TEXT, " +
                "DescriptionTask TEXT, " +
                "Day TEXT, " +
                "Time TEXT, " +
                "SubTaskID INTEGER);";

        String createSubTasksTable = "CREATE TABLE " + TABLE_SUBTASK + "(" +
                "SubTaskID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TitleSub TEXT, " +
                "DescriptionSub TEXT, " +
                "ImageSub TEXT);";

        String insertTasks = "INSERT INTO " + TABLE_TASK + " VALUES" +
                "(1, 'Trả lời Email', 'Trả lời mail phỏng vấn', '14 Jul 2024', '16:08', 1)," +
                "(2, 'Xem phim', 'Tinh Hà Xán Lạn', '15 Jul 2024', '22:08', 2)," +
                "(3, 'Chạy bộ', '100km', '14 Jul 2024', '17:00', 3)," +
                "(4, 'Mua sắm', 'Big C', '15 Jul 2024', '20:08', 4);";

        String insertSubTasks = "INSERT INTO " + TABLE_SUBTASK + " VALUES" +
                "(1, 'Càng sớm càng tốt', 'Trễ thì thất nghiệp', '')," +
                "(2, 'Phim hay', 'Mỗi ngày một tập', '')," +
                "(3, 'Hai chai nước', 'Nước suối', '')," +
                "(4, 'Cũng là nước', 'Mà là nước mắm', '');";

        String createLoginTable = "CREATE TABLE " + TABLE_LOGIN + "(" +
                "username TEXT PRIMARY KEY, " +
                "password TEXT);";

        db.execSQL(createTasksTable);
        db.execSQL(createSubTasksTable);
        db.execSQL(insertTasks);
        db.execSQL(insertSubTasks);
        db.execSQL(createLoginTable);
    }

    // Hàm này chỉ chạy khi thay đổi version của database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBTASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(db);
    }


    // Trỏ về phần tử đầu tiên
    Cursor initRecordFisrtDB(){
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cs = db.rawQuery("SELECT * FROM tasks", null);
            cs.moveToNext();
            return cs;
        }
        catch (Exception io) {

        }
        return null;
    }


    // Đọc dữ liệu
    SQLiteDatabase ketNoiDBRead() {
        SQLiteDatabase db = getReadableDatabase();
        return db;
    }
    // Viết dữ liệu
    SQLiteDatabase ketNoiDBWrite() {
        SQLiteDatabase db = getWritableDatabase();
        return db;
    }
}