package coachingmanagement.models;

public class Teacher {
    
    private String id, name, gender, dob, institute, degree;
    
    public Teacher(){
        
    }
    
    public Teacher(String id, String name, String gender, String dob, String institute, String degree) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.institute = institute;
        this.degree = degree;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", institute=" + institute + ", degree=" + degree + '}';
    }
    
    
    
}
