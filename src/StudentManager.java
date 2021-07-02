/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SY NGUYEN
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int mark = Inputter.inputInt("Mời bạn nhập điểm", 0,10);
        System.out.println("Bạn vừa nhập " + mark + " điểm");
        
        String s1 = Inputter.inputStr("Mời bạn nhập mô tả sản phẩm");
        System.out.println("Bạn vừa nhập #" + s1 + "#");
        
        String s2 = Inputter.inputNoBlankStr("Mời bạn nhập tên sinh viên");
        System.out.println("Bạn vừa nhập #" + s2 + "#");
        
        // nhập msv s000 hoặc S000
        // pattern với regex: [sS][\\d]{3}
        String s3 = Inputter.inputPattern("Mời bạn nhập mã sinh viên", "[sS][\\d]{3}");
        System.out.println("Bạn vừa nhập #" + s3 + "#");*/
        String[] options = {"Add new student", "Search a student", "Update name and mark", "Remove a student", "List all", "Quit"};
        int choice = 0;
        StudentList list = new StudentList();
        do {
            System.out.println("\n==================== Student managing Program ====================");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    list.addStudent();
                    break;
                case 2:
                    list.searchStudent();
                    break;
                case 3:
                    list.updateStudent();
                    break;
                case 4:
                    list.removeStudent();
                    break;
                case 5:
                    list.displayAll();
                    break;
                default:
                    System.out.println("Bye!");
            }
        } while (choice > 0 && choice < 6);
    }

}
