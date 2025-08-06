package Task_2;

import java.util.*;

 class Student {
    int id;
    String name;
    double marks;
    public Student(int id, String name, double marks){
        this.id=id;
        this.name= name;
        this.marks= marks;
    }
    public void display(){
        System.out.print("Id:" + id + "  Name:" + name + "  Marks:" + marks);
    }
    
}
public class StudentManagement{
    public static void main(String[]args){
        List<Student> students=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice =scanner.nextInt();
            if(choice == 1){
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Student Marks: ");
                double marks = scanner.nextDouble();
                students.add(new Student(id,name,marks));
                System.out.println("Student added successfully. ");
            }
            else if(choice == 2){
                if(students.isEmpty()){
                    System.out.println("No Students found.");
                }
                else{
                    System.out.println("--List of Students-- ");
                    System.out.println("----------------------");
                    for(Student s:students){
                    s.display();
                    System.out.println();
                    }
                }
            }
                else if(choice == 3){
                    System.out.print("Enter Student ID to update: ");
                    int id = scanner.nextInt();
                    boolean found=false;
                    for(Student s:students){
                        if(s.id == id){
                            found = true;
                            scanner.nextLine();
                            System.out.print("Enter new Student Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter new Student marks: ");
                            double marks = scanner.nextDouble();
                            s.name=name;
                            s.marks=marks;
                            System.out.println("Student updated successfully. ");
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Student with id " + id + " not found. ");
                    }
                }
            else if(choice == 4){
                System.out.print("Enter Student ID to delete: ");
                int id = scanner.nextInt();
                boolean found=false;
                for(int i=0;i<students.size();i++){
                    if(students.get(i).id == id){
                        found=true;
                        students.remove(i);
                        System.out.println("Student with id " + id + " deleted successfully. ");    
                        break;
                    }
                }
                if(!found){
                    System.out.println("Student with id " + id + " not found. ");
                }
            }
            else if(choice == 5){
                System.out.println("Exiting the Student Management System ...");
            }else{
                System.out.println("Invalid choice please try again");
            }
        } while(choice != 5);
        scanner.close();
    }
} 
