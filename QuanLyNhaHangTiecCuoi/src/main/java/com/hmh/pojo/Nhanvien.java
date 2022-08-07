/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findByMaNV", query = "SELECT n FROM Nhanvien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "Nhanvien.findByTenNV", query = "SELECT n FROM Nhanvien n WHERE n.tenNV = :tenNV"),
    @NamedQuery(name = "Nhanvien.findByS\u0111t", query = "SELECT n FROM Nhanvien n WHERE n.s\u0111t = :s\u0111t"),
    @NamedQuery(name = "Nhanvien.findByNgaySinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nhanvien.findByGioiTInh", query = "SELECT n FROM Nhanvien n WHERE n.gioiTInh = :gioiTInh"),
    @NamedQuery(name = "Nhanvien.findByLoaiNV", query = "SELECT n FROM Nhanvien n WHERE n.loaiNV = :loaiNV"),
    @NamedQuery(name = "Nhanvien.findByTaiKhoan", query = "SELECT n FROM Nhanvien n WHERE n.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "Nhanvien.findByMatKhau", query = "SELECT n FROM Nhanvien n WHERE n.matKhau = :matKhau")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNV")
    private Integer maNV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenNV")
    private String tenNV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "S\u0110T")
    private int sđt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "GioiTInh")
    private String gioiTInh;
    @Size(max = 45)
    @Column(name = "LoaiNV")
    private String loaiNV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MatKhau")
    private String matKhau;

    public Nhanvien() {
    }

    public Nhanvien(Integer maNV) {
        this.maNV = maNV;
    }

    public Nhanvien(Integer maNV, String tenNV, int sđt, Date ngaySinh, String gioiTInh, String taiKhoan, String matKhau) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sđt = sđt;
        this.ngaySinh = ngaySinh;
        this.gioiTInh = gioiTInh;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getSđt() {
        return sđt;
    }

    public void setSđt(int sđt) {
        this.sđt = sđt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTInh() {
        return gioiTInh;
    }

    public void setGioiTInh(String gioiTInh) {
        this.gioiTInh = gioiTInh;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Nhanvien[ maNV=" + maNV + " ]";
    }
    
}
