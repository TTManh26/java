package org.hello;

import org.hello.nguoidung;
import org.hello.dichvu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dichvu dichvu = new dichvu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChọn một chức năng:");
            System.out.println("1. Nhập danh sách người dùng.");
            System.out.println("2. Nhập phiếu thu.");
            System.out.println("3. Nhập phiếu chi.");
            System.out.println("4. Tính lương người dùng ở thời điểm hiện tại.");
            System.out.println("5. Tổng lợi nhận.");
            System.out.println("6. Thoát.");
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập tên người dùng: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập lương tháng: ");
                    double luongthang = scanner.nextDouble();
                    System.out.println("Nhập số ngày đã làm trong tháng: ");
                    int songaydalam = scanner.nextInt();
                    scanner.nextLine();
                    dichvu.themnguoidung(new nguoidung(ten, luongthang, songaydalam));
                    break;

                case 2:
                    System.out.print("Nhập số tiền thu: ");
                    double thu = scanner.nextDouble();
                    scanner.nextLine();
                    dichvu.themphieu(new giaodich("thu", thu));
                    break;

                case 3:
                    System.out.print("Nhập số tiền chi: ");
                    double chi = scanner.nextDouble();
                    scanner.nextLine();
                    dichvu.themphieu(new giaodich("chi", chi));
                    break;

                case 4:
                    System.out.print("Lương hiện tại của người dùng: ");
                    for (nguoidung nguoidung : dichvu.getdanhsachnguoidung()){
                        System.out.println("Lương của " + nguoidung.getten() +" : "
                                + String.format("%.0f", nguoidung.tinhluonghientai()));
                    }
                    break;
                case 5:
                    double loinhuan = dichvu.tinhloinhuan();
                    System.out.println("Lợi nhuận hiện tại: " + String.format("%.0f", loinhuan));
                    break;
                case 6:
                    System.out.println("Thoát.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}