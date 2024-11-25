package org.hello;
import org.hello.giaodich;
import org.hello.nguoidung;

import java.util.ArrayList;
import java.util.List;
public class dichvu {
    private final List<nguoidung> danhsachnguoidung = new ArrayList<>();
    private final List<giaodich> danhsachphieu = new ArrayList<>();

    public void themnguoidung(nguoidung nguoidung) {
        danhsachnguoidung.add(nguoidung);
    }

    public void themphieu(giaodich phieu) {
        danhsachphieu.add(phieu);
    }
    public double tinhloinhuan(){
        double tongthu = 0;
        double tongchi = 0;
        for (giaodich giaodich : danhsachphieu){
            if (giaodich.getloai().equals("thu")){
                tongthu += giaodich.getsotien();
            } else if (giaodich.getloai().equals("chi")){
                tongchi += giaodich.getsotien();
            }
        }
        return tongthu - tongchi;
    }
    public double tinhtongluonghientai(int songaydalam) {
        return danhsachnguoidung.stream()
                .mapToDouble(nguoidung -> nguoidung.getluongngay() * songaydalam).sum();
    }

    public List<nguoidung> getdanhsachnguoidung() {
        return danhsachnguoidung;
    }

    public List<giaodich> getdanhsachphieu() {
        return danhsachphieu;
    }
}