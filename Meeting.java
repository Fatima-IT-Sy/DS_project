public class Meeting implements IMeeting {
    private int eventId;
    private String title;
    private IDateTime startDateTime;
    private IDateTime endDateTime;
    private String location;
    private IStudent student;

    public Meeting(int eventId, String title, IDateTime start, IDateTime end, String location, IStudent student) {
        this.eventId = eventId;
        this.title = title;
        this.startDateTime = start;
        this.endDateTime = end;
        this.location = location;
        this.student = student;
    }

    @Override
    public int getEventId() { return eventId; }
    @Override
    public String getTitle() { return title; }
    @Override
    public void setTitle(String title) { this.title = title; }
    @Override
    public IDateTime getStartDateTime() { return startDateTime; }
    @Override
    public IDateTime getEndDateTime() { return endDateTime; }
    @Override
    public String getLocation() { return location; }
    @Override
    public void setLocation(String location) { this.location = location; }
    @Override
    public IStudent getStudent() { return student; }
    @Override
    public void setStudent(IStudent student) { this.student = student; }

    @Override
    public boolean hasStudent(int studentId) {
        return this.student != null && this.student.getStudentId() == studentId;
    }

    @Override
    public int compareTo(IEvent other) {
        return this.title.compareToIgnoreCase(other.getTitle());
    }

    @Override
    public String toString() {
        return "Meeting: " + title;
    }
}