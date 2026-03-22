public class Student {
    private String id;
    private String name;
    private SubjectList subjects;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new SubjectList();
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public SubjectList getSubjects() { return subjects; }
}
