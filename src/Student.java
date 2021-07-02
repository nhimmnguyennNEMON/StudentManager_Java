/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SY NGUYEN
 */
public class Student {

    protected String code;
    protected String name;
    protected int mark;

    public Student() {
    }

    public Student(String code, String name, int mark) {
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
        this.mark = (mark >= 0 && mark <= 10) ? mark : 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // trường truyền vào name = " " thì không hợp lệ
        // nên ta sẽ xử lý bằng cắt bỏ khoảng trống
        // rồi kiểm tra độ dài sau khi cắt bỏ khoảng trống
        name = name.trim().toUpperCase();
        if (name.length() > 0) {
            this.name = name; // check name valid
        }
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark; // check mark valid
        }
    }

    @Override
    public String toString() {
        return "Student: " + "code = " + code + ", name = " + name + ", mark = " + mark;
    }

}
