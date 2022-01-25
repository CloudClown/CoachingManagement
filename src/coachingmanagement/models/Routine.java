package coachingmanagement.models;

public class Routine {
    
    private String id, day, teacher, time, subject, className;

    public Routine() {
    }

    public Routine(String id, String day, String teacher, String time, String subject, String className) {
        this.id = id;
        this.day = day;
        this.teacher = teacher;
        this.time = time;
        this.subject = subject;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Routine{" + "id=" + id + ", day=" + day + ", teacher=" + teacher + ", time=" + time + ", subject=" + subject + ", className=" + className + '}';
    }
       
    
}
