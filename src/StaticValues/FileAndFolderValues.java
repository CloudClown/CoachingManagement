package StaticValues;


public class FileAndFolderValues {

    public static final String STORAGE_BASE_LOCATION = "E:\\class\\6th-sem\\Final-project\\CoachingManagement\\";
    public static final String TEACHER_FOLDER = "Teacher";
    public static final String TEACHER_FILE = "teacher.txt";
    public static final String STUDENT_FOLDER = "Student";
    public static final String STUDENT_FILE = "student.txt";
    public static final String ROUTINE_FOLDER = "Routine";
    public static final String ROUTINE_FILE = "routine.txt";

    public static String getFullPath(String... name) {
        String path = "";
        int i = 1;
        for (String s : name){
            path += s;
            if (i != name.length) {
                path += "/";
            }
            i++;
        } 

        return STORAGE_BASE_LOCATION + path;
    }

    public static enum FolderName {
        Teacher,
        Student,
        Routine,
        ClassRoom
    }

    public static enum FileName {
        teacher,
        student,
        routine,
        classRoom
    }
}
