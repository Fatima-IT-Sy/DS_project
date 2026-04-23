public class EventList implements IEventList {
    private LinkedList<IEvent> events;

    public EventList() {
        this.events = new LinkedList<IEvent>();
    }

    @Override
    public boolean addEvent(IEvent event) {
        if (!events.empty()) {
            events.findFirst();
            while (true) {
                if (events.retrieve().getEventId() == event.getEventId()) return false;
                if (events.last()) break;
                events.findNext();
            }
        }

        if (events.empty()) {
            events.insert(event);
            return true;
        }

        events.findFirst();
        if (events.retrieve().compareTo(event) > 0) {
            IEvent currentFirst = events.retrieve();
            events.update(event);
            events.insert(currentFirst);
            return true;
        }

        while (!events.last()) {
            IEvent current = events.retrieve();
            events.findNext();
            if (events.retrieve().compareTo(event) > 0) {
                events.findFirst();
                while (events.retrieve() != current) events.findNext();
                break;
            }
        }
        events.insert(event); 
        return true;
    }

    @Override
    public LinkedList<IEvent> findByStudentName(String studentFullName) {
        LinkedList<IEvent> result = new LinkedList<IEvent>();
        if (events.empty()) return result;

        events.findFirst();
        while (true) {
            IEvent currentEvent = events.retrieve();
            boolean found = false;

            if (currentEvent instanceof Meeting) {
                if (((Meeting) currentEvent).getStudent().getName().equalsIgnoreCase(studentFullName)) {
                    found = true;
                }
            } else if (currentEvent instanceof Workshop) {
                // البحث داخل قائمة مشاركين الورشة
                LinkedList<IStudent> participants = ((Workshop) currentEvent).getParticipants();
                if (!participants.empty()) {
                    participants.findFirst();
                    while (true) {
                        if (participants.retrieve().getName().equalsIgnoreCase(studentFullName)) {
                            found = true;
                            break;
                        }
                        if (participants.last()) break;
                        participants.findNext();
                    }
                }
            }

            if (found) result.insert(currentEvent);
            if (events.last()) break;
            events.findNext();
        }
        return result;
    }

    @Override
    public boolean removeEventById(int eventId) {
        if (events.empty()) return false;
        events.findFirst();
        while (true) {
            if (events.retrieve().getEventId() == eventId) {
                events.remove();
                return true;
            }
            if (events.last()) break;
            events.findNext();
        }
        return false;
    }

    @Override
    public LinkedList<IEvent> findByTitle(String title) {
        LinkedList<IEvent> result = new LinkedList<IEvent>();
        if (events.empty()) return result;
        events.findFirst();
        while (true) {
            if (events.retrieve().getTitle().equalsIgnoreCase(title)) {
                result.insert(events.retrieve());
            }
            if (events.last()) break;
            events.findNext();
        }
        return result;
    }

    @Override
    public LinkedList<IEvent> getAllAlphabetically() { return events; }

    @Override
    public int size() {
        int count = 0;
        if (events.empty()) return 0;
        events.findFirst();
        while (true) {
            count++;
            if (events.last()) break;
            events.findNext();
        }
        return count;
    }
}