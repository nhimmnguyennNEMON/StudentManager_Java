
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SY NGUYEN
 */
public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (Student i : this) {
            if (i.getCode().equals(code)) {
                return i; // trả về i nếu tìm thấy
            }
        }
        return null; // trả về null nếu không tìm thấy
    }

    private boolean isCodeDuplicated(String code) { // check xem code có trùng hay không
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStudent() { // add new student
        String newCode, newName;
        int newMark;
        boolean codeDuplicated = false;
        do {
            newCode = Inputter.inputPattern("Enter student code S000: ", "[sS][\\d]{3}"); // parttern: "[sS][\\d]{3}", [sS] - cho phép nhập s hoặc S
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode); // check xem code có trùng với code cữ hay không
            if (codeDuplicated) {
                System.out.println("Code is duplicated!");
            }
        } while (codeDuplicated == true);
        // create new student
        newName = Inputter.inputNoBlankStr("Name of new student: ");
        newName = newName.toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10); //mark = {0...10}
        Student st = new Student(newCode, newName, newMark);
        this.add(st); // add new student to the list
        System.out.println("Student " + newCode + " has been added.");
    }

    public void searchStudent() { //search student by code
        if (this.isEmpty()) {
            System.out.println("Empty list, No search can be performed!");
        } else {
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student st = this.search(sCode);
            if (st == null) {
                System.out.println("Student " + sCode + " doesn't existed!");
            } else {
                System.out.println("Found: " + st);
            }
        }
    }

    public void updateStudent() { //update name and mark of student's by code
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String uCode = Inputter.inputStr("Input code of updated student: ");
            Student st = this.search(uCode); //search student
            if (st == null) {
                System.out.println("Student " + uCode + " doesn't existed!");
            } else {
                String oldName = st.getName(); // updated name
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = Inputter.inputNoBlankStr(msg);
                st.setName(newName);
                int oldMark = st.getMark(); // updated mark
                msg = "Old mark: " + oldMark + ", new mark 0...10: ";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Studenrs " + uCode + " has been updated.");
            }
        }
    }

    public void removeStudent() { //remove name and mark of student's by code
        if (this.isEmpty()) {
            System.out.println("Empty list. No remove can be performed!");
        } else {
            String rCode = Inputter.inputStr("Input code of removed student: ");
            Student st = this.search(rCode); //search student
            if (st == null) {
                System.out.println("Student " + rCode + " doesn't existed!");
            } else {
                this.remove(st); // gọi đến hàm remove trong ArrayList
                System.out.println("Student " + rCode + " has been removed");
            }
        }
    }

    public void displayAll() { //in ra màn hình list sinh viên
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("==================== Student list: ====================");
            for (Student st : this) {
                System.out.println(st);
            }
            System.out.println("Total: " + this.size() + " Student(s).");
        }
    }

}
