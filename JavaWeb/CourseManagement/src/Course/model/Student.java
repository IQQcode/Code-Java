package Course.model;

/**
 * 学生实体类
 * @author Course
 *
 */

public class Student {

    String id;
    String name;
    String password;
    String major;
    String grade;
    String sclass;
    String selectedCourse;


    public Student() {  }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String cid) {
        this.selectedCourse = cid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }
}
