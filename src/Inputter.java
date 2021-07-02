
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SY NGUYEN
 */
public class Inputter {

    public static Scanner sc = new Scanner(System.in);

    public static int inputInt(String msg, int min, int max) {
        //phương thức giúp hiển thị ra một mssg
        // yc người dùng nhập vào một số nguyên trong khoảng min...max
        // nếu người dùng nhập k hợp lệ thì in thông báo lỗi
        // và lặp cho khi nhập dúng thì thôi
        System.out.println(msg);
        if (min > max) {
            // đảo chỗ min, max cho nhau
            int tmp = 0;
        }
        int output = -1;
        do {
            //System.out.print("Nhập dữ liệu: ");
            String s = sc.nextLine();
            try {
                output = Integer.parseInt(s);
                if (output >= min && output <= max) {
                    break;
                } else {
                    System.out.println("Bạn nhập dữ liệu không trong khoảng quy định");
                    System.out.println("Hãy nhập lại!");
                    continue;   // tiếp tục lần lặp tiếp theo
                }
            } catch (Exception e) {
                System.err.println("Dữ liệu không hợp lệ.");
            }
        } while (output < min || output > max);

        return output;
    }

    public static String inputStr(String msg) {
        System.out.println(msg);
        //System.out.print("Nhập dữ liệu: ");
        String s = sc.nextLine().trim();
        return s;
    }

    public static String inputNoBlankStr(String msg) {
        String output;
        do {
            System.out.println(msg);
            //System.out.print("Nhập dữ liệu: ");
            output = sc.nextLine().trim();
            if (output.equals("")) {
                System.err.println("Dữ liệu không được để trống mời bạn nhập lại!");
            }
        } while (output.equals(""));

        return output;
    }

    public static String inputPattern(String msg, String pattern) {
        // phương thức nhập vào chuỗi tuân thử định dạng
        // đucợ quy định theo pattrn
        //vd: msv S000 trong đó 0 là digit
        String output;
        do {
            System.out.println(msg);
            //System.out.print("Nhập dữ liệu: ");
            output = sc.nextLine().trim();
            if (output.equals("") || !output.matches(pattern)) {
                System.err.println("Bạn phải nhập chuỗi rỗng hoặc MSV có dạng [sS][\\d]{3}");
            }
        } while (!output.matches(pattern));

        return output;
    }
}
