/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "chitietsanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitietsanh.findAll", query = "SELECT c FROM Chitietsanh c"),
    @NamedQuery(name = "Chitietsanh.findByMaChiTiet", query = "SELECT c FROM Chitietsanh c WHERE c.maChiTiet = :maChiTiet"),
    @NamedQuery(name = "Chitietsanh.findByGia", query = "SELECT c FROM Chitietsanh c WHERE c.gia = :gia")})
public class Chitietsanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaChiTiet")
    private Integer maChiTiet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private long gia;
    @JoinColumn(name = "ca_MaCa", referencedColumnName = "MaCa")
    @ManyToOne(optional = false)
    private Ca caMaCa;
    @JoinColumn(name = "sanh_MaSanh", referencedColumnName = "MaSanh")
    @ManyToOne(optional = false)
    private Sanh sanhMaSanh;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chitietsanhMaChiTiet")
    private Set<Hoadon> hoadonSet;

    public Chitietsanh() {
    }

    public Chitietsanh(Integer maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public Chitietsanh(Integer maChiTiet, long gia) {
        this.maChiTiet = maChiTiet;
        this.gia = gia;
    }

    public Integer getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(Integer maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public Ca getCaMaCa() {
        return caMaCa;
    }

    public void setCaMaCa(Ca caMaCa) {
        this.caMaCa = caMaCa;
    }

    public Sanh getSanhMaSanh() {
        return sanhMaSanh;
    }

    public void setSanhMaSanh(Sanh sanhMaSanh) {
        this.sanhMaSanh = sanhMaSanh;
    }

    @XmlTransient
    public Set<Hoadon> getHoadonSet() {
        return hoadonSet;
    }

    public void setHoadonSet(Set<Hoadon> hoadonSet) {
        this.hoadonSet = hoadonSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChiTiet != null ? maChiTiet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitietsanh)) {
            return false;
        }
        Chitietsanh other = (Chitietsanh) object;
        if ((this.maChiTiet == null && other.maChiTiet != null) || (this.maChiTiet != null && !this.maChiTiet.equals(other.maChiTiet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Chitietsanh[ maChiTiet=" + maChiTiet + " ]";
    }
    
}
