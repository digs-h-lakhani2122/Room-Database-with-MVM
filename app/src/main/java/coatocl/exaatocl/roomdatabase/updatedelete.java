package coatocl.exaatocl.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class updatedelete extends AppCompatActivity {

    int position;
    String stu_name1,stu_department1,stu_semester1,stu_project1;
    EditText nameEdit2,projectEdit2;
    Spinner departmentEdit2,semesterEdit2;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedelete);

        nameEdit2=findViewById(R.id.nameEdit2);
        projectEdit2=findViewById(R.id.projectEdit2);
        departmentEdit2=findViewById(R.id.departmentEdit2);
        semesterEdit2=findViewById(R.id.semesterEdit2);
        button2 = findViewById(R.id.button2);

//        spinner adapter for department
        ArrayAdapter<?> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.student_department, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        departmentEdit2.setAdapter(arrayAdapter);

//        spinner adapter for semester
        ArrayAdapter<?> arrayAdapter1 = ArrayAdapter.createFromResource(this, R.array.student_semester, android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        semesterEdit2.setAdapter(arrayAdapter1);

//        for update intent
//        Intent i =getIntent();
//        Bundle bundle = i.getBundleExtra("BUNDLE");
//        position =bundle.getInt("position");
//        stu_name1 = (String) bundle.get("name");
//        stu_department1 = (String) bundle.get("department");
//        stu_semester1 = (String) bundle.get("semester");
//        stu_project1 = (String) bundle.get("project");
//
//        nameEdit2.setText(stu_name1);
//        projectEdit2.setText(stu_project1);
//        departmentEdit2.setSelection(Integer.parseInt(stu_department1));
//        semesterEdit2.setSelection(Integer.parseInt(stu_semester1));
//
//        final CustomModel customModel = (CustomModel) getIntent().getSerializableExtra("task");
//        loadData(customModel);
//
    }
//
//    private void loadData(CustomModel customModel)
//    {
//        nameEdit2.setText(customModel.getS_name());
//        projectEdit2.setText(customModel.getS_project());
//        departmentEdit2.setSelection(Integer.parseInt(customModel.getS_department()));
//        semesterEdit2.setSelection(Integer.parseInt(customModel.getS_semester()));
//    }
}
