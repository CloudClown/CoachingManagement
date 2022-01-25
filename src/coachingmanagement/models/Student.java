package coachingmanagement.models;

public class Student {
    
    private String id, name, gender, dob, institute, rollNo, className, createdAt;

    public Student() {
    }

    public Student(String id, String name, String gender, String dob, String institute, String rollNo, String className) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.institute = institute;
        this.rollNo = rollNo;
        this.className = className;
    }

    public Student(String id, String name, String gender, String dob, String institute, String rollNo, String className, String createdAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.institute = institute;
        this.rollNo = rollNo;
        this.className = className;
        this.createdAt = createdAt;
    }
    
    

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", institute=" + institute + ", rollNo=" + rollNo + ", className=" + className + ", createdAt=" + createdAt + '}';
    }
}
