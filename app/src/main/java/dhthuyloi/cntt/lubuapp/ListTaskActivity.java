package dhthuyloi.cntt.lubuapp;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import dhthuyloi.cntt.lubuapp.model.Task;

public class ListTaskActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor cs;
    ListView lvtask;
    ArrayList<Task> arrtask;
    CustomAdapter adapter;
    DBHelperDatabase dbh;
    TextView id, title, des,time, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_list_task);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        lvtask = findViewById(R.id.lvtask);
        arrtask = new ArrayList<>();
        /*arrtask.add(new Task("Rep ib crush","3.30 AM","EveryDay"));
        arrtask.add(new Task("Play PUBG","4.30 AM","EveryDay"));
        arrtask.add(new Task("Listen to music","7.30 PM","EveryDay"));
        arrtask.add(new Task("Eat","1.30 AM","EveryDay"));
        arrtask.add(new Task("Rep ib crush","3.30 AM","EveryDay"));
        arrtask.add(new Task("Play PUBG","4.30 AM","EveryDay"));
        arrtask.add(new Task("Listen to music","7.30 PM","EveryDay"));
        arrtask.add(new Task("Eat","1.30 AM","EveryDay"));*/
        adapter = new CustomAdapter(this, arrtask);
        lvtask.setAdapter(adapter);
        dbh = new DBHelperDatabase(this);
        cs = dbh.initRecordFisrtDB();
        showDataListView();
    }
    private void showDataListView(){
        db = dbh.ketNoiDBRead();
        // String s = title.getText().toString();
        arrtask = new ArrayList<>();
        //Cursor cursor = db.rawQuery("SELECT * FROM TASKS where TaskID like '%"+s+"%' or TitleTask like '%"+s+"%'", null);
        Cursor cursor = db.rawQuery("SELECT * FROM tasks" , null);
        try {
            while (cursor.moveToNext()) {
                Task t = new Task(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(4),cursor.getString(3));
                /*View.OnClickListener onDeleteClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = (int) v.getTag();
                        //Task bookToDelete = arrtask.get(position);
                        //showDialogconfirm(bookToDelete.getBookname(), bookToDelete.getBookid());
                    }
                };*/

                arrtask.add(t);
                adapter= new CustomAdapter(this, arrtask);
                lvtask.setAdapter(adapter);
            }

        } finally {
            cursor.close();
        }
    }

    void updateRecord() {
        id.setText(cs.getString(0));
        title.setText(cs.getString(1));
        des.setText(cs.getString(2));
        time.setText(cs.getString(3));
        day.setText(cs.getString(4));

    }
}