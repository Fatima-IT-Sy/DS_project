/**
 * Implementation of the Student class for the Student Advising System.
 * This class represents a single student and handles their profile and schedule.
 */
public class Student implements IStudent{
 private String name;
 private final int studentId; // Final because ID must not be modified after creation
 private String email;
 private String major;
 private int yearLevel;
 private String notes;
 private LinkedList<IEvent> schedule; //every student has list of events 
 //constructor to initialize attributes value based on student profile
 public Student(String name, int studentId, String email, String major, int yearLevel, String notes){
   this.name=name;
   this.studentId=studentId;
   this.email=email;
   this.major=major;
   this.yearLevel=yearLevel;
   this.notes=notes;
   schedule= new LinkedList<IEvent>();
 }
 //setters and getters
 public String getName() {
   return name;
 }
 public void setName(String name){
   this.name=name;
 }
 public int getStudentId(){
   return studentId;
 }
 public String getEmail(){
  return email;
 }
 public void setEmail(String email){
  this.email = email;
 }
 public String getMajor(){
  return major;
 }
 public void setMajor(String major){
  this.major=major;
 }
 public int getYearLevel(){
  return yearLevel;
 }
 public void setYearLevel(int year){
  yearLevel=year;
 }
 public String getNotes(){
  return notes;
 }
 public void setNotes(String notes){
  this.notes=notes;
 }
 //split first name in an array and returns first element because it contains the first name 
 public String getFirstName(){
  return name.split(" ")[0];
 }
 public LinkedList<IEvent> getSchedule(){
  return schedule;
 }
 /* Compares students based on their studentId
     * Required for keeping the StudentList sorted
     */
 public int compareTo(IStudent other){
  if (this.studentId == other.getStudentId()) return 0;
        return (this.studentId < other.getStudentId()) ? -1 : 1;
 }
 //printing data of student
 public String toString(){
  return "Student ID: " + studentId + 
               "\nName: " + name + 
               "\nEmail: " + email + 
               "\nMajor: " + major + 
               "\nYear Level: " + yearLevel + 
               "\nNotes: " + notes; }


}