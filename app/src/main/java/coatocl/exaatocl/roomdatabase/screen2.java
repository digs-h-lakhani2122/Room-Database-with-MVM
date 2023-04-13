package coatocl.exaatocl.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class screen2 extends AppCompatActivity {

    EditText nameEdit,projectEdit;
    Spinner departmentEdit,semesterEdit;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        nameEdit=findViewById(R.id.nameEdit);
        projectEdit=findViewById(R.id.projectEdit);
        departmentEdit=findViewById(R.id.departmentEdit);
        semesterEdit=findViewById(R.id.semesterEdit);
        button = findViewById(R.id.button);

//        spinner adapter for department
        ArrayAdapter<?> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.student_department, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        departmentEdit.setAdapter(arrayAdapter);

//        spinner adapter for semester
        ArrayAdapter<?> arrayAdapter1 = ArrayAdapter.createFromResource(this, R.array.student_semester, android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        semesterEdit.setAdapter(arrayAdapter1);

        button.setOnClickListener(v -> saveTask());

    }

    private void saveTask()
    {
        String sName = nameEdit.getText().toString().trim();
        String sProject= projectEdit.getText().toString().trim();
        String sSemester = semesterEdit.getSelectedItem().toString();
        String sDepartment = departmentEdit.getSelectedItem().toString();

        if (sName.isEmpty()) {
            nameEdit.setError("Task required");
            nameEdit.requestFocus();
            return;
        }

        if (sProject.isEmpty()) {
            projectEdit.setError("Desc required");
            projectEdit.requestFocus();
            return;
        }

//        if (sDate.isEmpty()) {
//            dateEdit.setError("Finish by required");
//            dateEdit.requestFocus();
//            return;
//        }

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                CustomModel customModel = new CustomModel();
                customModel.setS_name(sName);
                customModel.setS_project(sProject);
                customModel.setS_semester(sSemester);
                customModel.setS_department(sDepartment);
//                customModel.setFinished(false);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .dao()
                        .insert(customModel);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();

    }

}
