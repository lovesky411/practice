package karamel.dev.studio.doitmission09;

import android.text.Editable;

public class Customer {

    private String name;
    private String phone;
    private String birth;
    private int resId;

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Customer(String name, String phone, String birth, int resId) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.resId = resId;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
