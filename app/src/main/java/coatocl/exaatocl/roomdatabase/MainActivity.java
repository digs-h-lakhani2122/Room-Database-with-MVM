package coatocl.exaatocl.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recycler;
    LinearLayoutManager linearLayoutManager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        linearLayoutManager =new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, screen2.class);
            startActivity(intent);
        });
        
        getTask();

    }

    private void getTask()
    {
        class GetTasks extends AsyncTask<Void, Void, List<CustomModel>> {

            @Override
            protected List<CustomModel> doInBackground(Void... voids) {
                List<CustomModel> taskList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .dao()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<CustomModel> listItem) {
                super.onPostExecute(listItem);

                adapter = new Adapter(MainActivity.this, listItem);
                recycler.setAdapter(adapter);
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }
}