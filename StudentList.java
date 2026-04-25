/* Implementation of the StudentList class.
 * This class manages a sorted list of students using a custom LinkedList.
 */
public class StudentList implements IStudentList {
  private LinkedList<IStudent> students;
  private int size = 0;

  // Constructor to initialize the empty list of students
  public StudentList() {
    students = new LinkedList<IStudent>();
  }

  // Inserts a student into the list in sorted order by studentId. If a student
  // with the same ID already exists, insertion fails.
  public boolean add(IStudent student) {
    // First, check if the student ID already exists to maintain uniqueness
    if (findById(student.getStudentId()) != null)
      return false;
    // Case 1: If the list is empty, insert the student as the first element
    if (students.empty()) {
      students.insert(student);
      size++;
      return true;
    }
    // current pointer on first node
    students.findFirst();
    // Case 2: Insertion at the beginning (if the new ID is smaller than the first
    // one)
    if (students.retrieve().getStudentId() > student.getStudentId()) {
      IStudent firstElem = students.retrieve();
      students.update(student); // Replace current first with the new student
      students.insert(firstElem); // Re-insert the old first student after the new one
      size++;
      return true;
    }
    // Case 3: Insertion in the middle or at the end
    // We find the 'prevId' which is the ID of the last student smaller than the new
    // one
    int prevId = -1;
    while (!students.last() && students.retrieve().compareTo(student) == -1) {
      prevId = students.retrieve().getStudentId();
      students.findNext();
    }
    // handle last element
    if (students.retrieve().compareTo(student) == -1)
      prevId = students.retrieve().getStudentId();
    // we have the largest id less than new Id, we will start from first of the list
    // and stop at id=prevId
    // to insert after id=prevId the new obj to the list to be sorted correctly
    students.findFirst();
    while (!students.last() && students.retrieve().getStudentId() != prevId)
      students.findNext();
    // inserting the new obj
    students.insert(student);
    size++;
    return true;
  }

  // Searches for a student by student ID.
  public IStudent findById(int studentId) {
    // Case1: Return null if the list is empty
    if (students.empty())
      return null;
    students.findFirst();
    // Case2: Traverse the list until the last element or until the student is found
    while (!students.last() && students.retrieve().getStudentId() != studentId) {
      students.findNext();
    }
    // Check if the current student matches the given ID
    if (students.retrieve().getStudentId() == studentId)
      return students.retrieve();
    // Return null if no matching student is found
    return null;
  }

  // Searches for all students with the given full name.
  public LinkedList<IStudent> findByName(String fullName) {
    // List to store matching students
    LinkedList<IStudent> nameList = new LinkedList<IStudent>();
    // Case1: Return empty list if no students exist
    if (students.empty())
      return nameList;
    students.findFirst();
    // Traverse all elements except the last
    while (!students.last()) {
      // Check for exact name match and insert it into the list
      if (students.retrieve().getName().equals(fullName))
        nameList.insert(students.retrieve());
      students.findNext();
    }
    // Handle last element
    if (students.retrieve().getName().equals(fullName))
      nameList.insert(students.retrieve());
    return nameList;
  }

  // Searches for all students whose full name contains the given substring. The
  // match should be case-insensitive.
  public LinkedList<IStudent> findByNameContains(String partialName) {
    // List to store matching students
    LinkedList<IStudent> nameContList = new LinkedList<IStudent>();
    // }Case 1: Return empty list if no students
    if (students.empty())
      return nameContList;

    students.findFirst();
    String name;
    // Case2: Convert search text to lowercase for case insensitive comparison
    while (!students.last()) {
      name = students.retrieve().getName().toLowerCase();
      // Check if name contains the search substring
      if (name.contains(partialName.toLowerCase())) {
        nameContList.insert(students.retrieve());
      }
      students.findNext();
    }
    // Handle last element
    name = students.retrieve().getName().toLowerCase();
    if (name.contains(partialName.toLowerCase())) {
      nameContList.insert(students.retrieve());
    }

    return nameContList;
  }

  // Searches for a student by email address.
  public IStudent findByEmail(String email) {
    // Case1: Return null if the list is empty
    if (students.empty())
      return null;
    students.findFirst();
    // Case2: Traverse all elements except the last
    while (!students.last()) {
      // Check if current student's email matches
      if (students.retrieve().getEmail().equals(email))
        return students.retrieve();
      students.findNext();
    }
    // Check last element
    if (students.retrieve().getEmail().equals(email))
      return students.retrieve();
    // Return null if no match is found
    return null;
  }

  // Returns all students with the specified major.
  public LinkedList<IStudent> findByMajor(String major) {
    // List to store matching students
    LinkedList<IStudent> majorList = new LinkedList<IStudent>();
    // Case1: Return empty list if no students exist
    if (students.empty())
      return majorList;

    students.findFirst();
    // Case2: Traverse all elements except the last
    while (!students.last()) {
      // Check if current student's major matches
      if (students.retrieve().getMajor().equals(major))
        majorList.insert(students.retrieve());
      students.findNext();
    }
    // Handle last element
    if (students.retrieve().getMajor().equals(major))
      majorList.insert(students.retrieve());
    return majorList;
  }

  // Returns all students in the specified year level.
  public LinkedList<IStudent> findByYearLevel(int yearLevel) {
    // List to store matching students
    LinkedList<IStudent> yearLevelList = new LinkedList<IStudent>();
    // Case1: Return empty list if no students exist
    if (students.empty())
      return yearLevelList;
    students.findFirst();
    // Case2: Traverse all elements except the last
    while (!students.last()) {
      // Check if current student's year level matches
      if (students.retrieve().getYearLevel() == yearLevel)
        yearLevelList.insert(students.retrieve());
      students.findNext();
    }
    // handle last element
    if (students.retrieve().getYearLevel() == yearLevel)
      yearLevelList.insert(students.retrieve());
    return yearLevelList;
  }

  // Returns all students in the linked list.
  public LinkedList<IStudent> getAll() {
    // List to store matching students
    LinkedList<IStudent> allStudents = new LinkedList<IStudent>();
    // Case1: Return empty list if no students exist
    if (students.empty())
      return allStudents;
    students.findFirst();
    // Case2: Traverse all elements except the last to isert them all into a new
    // list
    while (!students.last()) {
      allStudents.insert(students.retrieve());
      students.findNext();
    }
    // add last element
    allStudents.insert(students.retrieve());
    return allStudents;
  }

  // Deletes a student by student ID.
  public boolean deleteById(int studentId) {
    // Case1: Return false if no students exist
    if (students.empty())
      return false;
    students.findFirst();
    // Case2: Traverse all elements except the last
    while (!students.last()) {
      // Check if current student matches the ID
      if (students.retrieve().getStudentId() == studentId) {
        students.remove();
        size--;
        return true;
      }
      students.findNext();
    }
    // Check last element
    if (students.retrieve().getStudentId() == studentId) {
      students.remove();
      size--;
      return true;
    }
    // Return false if student not found
    return false;
  }

  // return the total number of students stored.
  public int size() {
    return size;
  }
}