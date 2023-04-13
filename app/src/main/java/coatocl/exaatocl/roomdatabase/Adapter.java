package coatocl.exaatocl.roomdatabase;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{

    private Context context;
    private List<CustomModel>listItem;

    public Adapter(Context context, List<CustomModel> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.part,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        CustomModel customModel = listItem.get(position);

        holder.s_name.setText(customModel.getS_name());
        holder.s_department.setText(customModel.getS_department());
        holder.s_semester.setText(customModel.getS_semester());
        holder.s_project.setText(customModel.getS_project());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context,"Student Name:"+customModel.getS_name(),Toast.LENGTH_SHORT).show();
//
////            String nameStudent = customModel.getS_name();
////            String departmentStudent = customModel.getS_department();
////            String semesterStudent = customModel.getS_semester();
////            String projectStudent = customModel.getS_project();
////
////            Intent intentUpdate = new Intent(context,updatedelete.class);
////            Bundle bundle = new Bundle();
////            bundle.putSerializable("name",nameStudent);
////            bundle.putSerializable("department",departmentStudent);
////            bundle.putSerializable("semester",semesterStudent);
////            bundle.putSerializable("project",projectStudent);
////
////            intentUpdate.putExtra("BUNDLE",bundle);
////
////            bundle.putInt("position",position);
////
////            context.startActivity(intentUpdate);
//
//            Intent intentUpdate = new Intent(context,updatedelete.class);
//            intentUpdate.putExtra("task",customModel);
//            context.startActivity(intentUpdate);
//
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView s_name,s_department,s_semester,s_project;
        ImageButton updateEdit,deleteEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            s_name = itemView.findViewById(R.id.t1);
            s_department = itemView.findViewById(R.id.t2);
            s_semester = itemView.findViewById(R.id.t3);
            s_project = itemView.findViewById(R.id.t4);

            updateEdit = itemView.findViewById(R.id.updateEdit);
            deleteEdit = itemView.findViewById(R.id.deleteEdit);

        }
    }
}

