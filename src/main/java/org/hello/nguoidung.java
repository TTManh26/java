package org.hello;
public class nguoidung {
    private String ten;
    private double luongthang;
    private int songaydalam;

    public nguoidung(String ten, double luongthang, int songaydalam) {
        this.ten = ten;
        this.luongthang = luongthang;
        this.songaydalam = songaydalam;
    }

    public String getten() {
        return ten;
    }

    public double getluongngay() {
        return luongthang / 22;
    }

    public double tinhluonghientai() {
        return getluongngay() * songaydalam;
    }

    public void setSongaydalam(int songaydalam) {
        this.songaydalam = songaydalam;
    }

    @Override
    public String toString() {
        return "Người dùng{tên='" + ten + "', lương tháng=" + luongthang + ", số ngày đã làm = " + songaydalam + "}";
    }
}