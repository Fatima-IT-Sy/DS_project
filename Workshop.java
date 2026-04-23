public class Workshop implements IWorkshop {
    private int eventId;
    private String title;
    private IDateTime startDateTime;
    private IDateTime endDateTime;
    private String location;
    
    private LinkedList<IStudent> participants;

    public Workshop(int eventId, String title, IDateTime startDateTime, IDateTime endDateTime, String location) {
        this.eventId = eventId;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.participants = new LinkedList<IStudent>(); 
            }


    @Override
    public int getEventId() {
        return eventId; // [cite: 51]
    }

    @Override
    public String getTitle() {
        return title; // [cite: 51]
    }

    @Override
    public void setTitle(String title) {
        this.title = title; // [cite: 52]
    }

    @Override
    public IDateTime getStartDateTime() {
        return startDateTime; // [cite: 52]
    }

    @Override
    public IDateTime getEndDateTime() {
        return endDateTime; // [cite: 53]
    }

    @Override
    public String getLocation() {
        return location; // [cite: 53]
    }

    @Override
    public void setLocation(String location) {
        this.location = location; // [cite: 54]
    }


    @Override
    public LinkedList<IStudent> getParticipants() {
        return participants; // [cite: 59]
    }

    @Override
    public boolean addParticipant(IStudent student) {
        if (hasStudent(student.getStudentId())) {
            return false;
        }
        participants.insert(student); 
        return true;
    }

    @Override
    public boolean removeParticipantById(int studentId) {
        if (participants.empty()) return false; // [cite: 61]

        participants.findFirst();
        while (true) {
            if (participants.retrieve().getStudentId() == studentId) {
                participants.remove(); 
                return true;
            }
            if (participants.last()) break;
            participants.findNext();
        }
        return false;
    }

    @Override
    public boolean hasStudent(int studentId) {
        if (participants.empty()) return false; // [cite: 55]

        participants.findFirst();
        while (true) {
            if (participants.retrieve().getStudentId() == studentId) {
                return true;
            }
            if (participants.last()) break;
            participants.findNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return participants.empty(); // [cite: 61]
    }


    @Override
    public int compareTo(IEvent other) {
        return this.title.compareToIgnoreCase(other.getTitle());
    }

    @Override
    public String toString() {
        return "Workshop Event: " + title + " | Participants: " + (isEmpty() ? "None" : "Multiple"); // [cite: 55]
    }
}