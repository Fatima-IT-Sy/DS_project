Student Advising System - CSC 212 Project 

King Saud University | CCIS | 
Spring 2026 

 Project Overview

This application is a Student Advising System designed to manage student records and schedule advising events (Meetings and Workshops) using custom-implemented data structures in Java. 
 Team Members

    Fatima (Student 1) 

    Zaina (Student 2) 

    Layan (Student 3) 

    Key Features

    Student Management: Add, search (by ID, Name, Email, Major), and delete student records. 

    Event Scheduling: Schedule Meetings (1-on-1) and Workshops (Group sessions). 

    Conflict Detection: The system ensures no overlapping schedules for any student. 

    Cascade Deletion: Automatically removes a student from all events or deletes events if the student was the only participant. 

    Data Persistence: Loads data from CSV files (students_100.csv and events_40.csv). 

   Core Data Structures

    Custom Linked List: Used for StudentList and EventList (Java's built-in java.util.LinkedList is not used). 

    Sorted Order: Students are maintained in sorted order by studentId for optimized access.
