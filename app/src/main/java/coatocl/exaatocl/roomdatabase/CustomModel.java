package coatocl.exaatocl.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity()

public class CustomModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name ="name")
    private String s_name;

    @ColumnInfo(name ="project")
    private String s_project;

    @ColumnInfo(name ="semester")
    private String s_semester;

    @ColumnInfo(name ="department")
    private String s_department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_project() {
        return s_project;
    }

    public void setS_project(String s_project) {
        this.s_project = s_project;
    }

    public String getS_semester() {
        return s_semester;
    }

    public void setS_semester(String s_semester) {
        this.s_semester = s_semester;
    }

    public String getS_department() {
        return s_department;
    }

    public void setS_department(String s_department) {
        this.s_department = s_department;
    }
}
