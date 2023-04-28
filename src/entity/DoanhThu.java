package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class DoanhThu {
    public String id;
    public double thanhtien;
    public Timestamp thoiGian;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public DoanhThu(String id, double thanhtien, Timestamp thoiGian) {
        super();
        this.id = id;
        this.thanhtien = thanhtien;
        this.thoiGian = thoiGian;
    }

    public DoanhThu() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thanhtien, thoiGian);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoanhThu other = (DoanhThu) obj;
        return Objects.equals(id, other.id)
                && Double.doubleToLongBits(thanhtien) == Double.doubleToLongBits(other.thanhtien)
                && Objects.equals(thoiGian, other.thoiGian);
    }

    @Override
    public String toString() {
        return "DoanhThu [id=" + id + ", thanhtien=" + thanhtien + ", thoiGian=" + thoiGian + "]";
    }

}
