/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tmh.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "ca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ca.findAll", query = "SELECT c FROM Ca c"),
    @NamedQuery(name = "Ca.findByMaCa", query = "SELECT c FROM Ca c WHERE c.maCa = :maCa"),
    @NamedQuery(name = "Ca.findByTenCa", query = "SELECT c FROM Ca c WHERE c.tenCa = :tenCa")})
public class Ca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCa")
    private Integer maCa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenCa")
    private String tenCa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caMaCa")
    private Set<Chitietsanh> chitietsanhSet;

    public Ca() {
    }

    public Ca(Integer maCa) {
        this.maCa = maCa;
    }

    public Ca(Integer maCa, String tenCa) {
        this.maCa = maCa;
        this.tenCa = tenCa;
    }

    public Integer getMaCa() {
        return maCa;
    }

    public void setMaCa(Integer maCa) {
        this.maCa = maCa;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    @XmlTransient
    public Set<Chitietsanh> getChitietsanhSet() {
        return chitietsanhSet;
    }

    public void setChitietsanhSet(Set<Chitietsanh> chitietsanhSet) {
        this.chitietsanhSet = chitietsanhSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCa != null ? maCa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ca)) {
            return false;
        }
        Ca other = (Ca) object;
        if ((this.maCa == null && other.maCa != null) || (this.maCa != null && !this.maCa.equals(other.maCa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tmh.pojo.Ca[ maCa=" + maCa + " ]";
    }
    
}
