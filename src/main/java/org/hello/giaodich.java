package org.hello;
public class giaodich {
    private String loai; //
    private double sotien;

    public giaodich(String loai, double sotien) {
        this.loai = loai;
        this.sotien = sotien;
    }

    public String getloai() {
        return loai;
    }

    public double getsotien() {
        return sotien;
    }

    @Override
    public String toString() {
        return "Phiếu{loại='" + loai + "', Số tiền=" + sotien + "}";
    }
}