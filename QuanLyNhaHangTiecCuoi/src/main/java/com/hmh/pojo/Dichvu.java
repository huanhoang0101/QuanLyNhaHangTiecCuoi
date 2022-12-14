/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "dichvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dichvu.findAll", query = "SELECT d FROM Dichvu d"),
    @NamedQuery(name = "Dichvu.findByMaDV", query = "SELECT d FROM Dichvu d WHERE d.maDV = :maDV"),
    @NamedQuery(name = "Dichvu.findByTenDV", query = "SELECT d FROM Dichvu d WHERE d.tenDV = :tenDV"),
    @NamedQuery(name = "Dichvu.findByGia", query = "SELECT d FROM Dichvu d WHERE d.gia = :gia")})
public class Dichvu implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45, message = "{dichvu.name.err}")
    @Column(name = "TenDV")
    private String tenDV;
    @Basic(optional = false)
    @NotNull(message = "{dichvu.price.minErr}")
    @Column(name = "Gia")
    @Min(value = 10000, message = "{dichvu.price.minErr}")
    @Max(value = 10000000, message = "{dichvu.price.maxErr}")
    private Long gia;
    @Size(max = 1000)
    @Column(name = "image")
    @NotNull(message = "{dichvu.image.err}")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dichvuId")
    @JsonIgnore
    private Set<CommentDichvu> commentDichvuSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDV")
    private Integer maDV;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dichvuMaDV")
    @JsonIgnore
    private Set<Hoadondichvu> hoadondichvuSet;
    @Transient
    private MultipartFile file; 

    public Dichvu() {
    }

    public Dichvu(Integer maDV) {
        this.maDV = maDV;
    }

    public Dichvu(Integer maDV, String tenDV, Long gia) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.gia = gia;
    }

    public Integer getMaDV() {
        return maDV;
    }

    public void setMaDV(Integer maDV) {
        this.maDV = maDV;
    }
    @XmlTransient
    public Set<Hoadondichvu> getHoadondichvuSet() {
        return hoadondichvuSet;
    }

    public void setHoadondichvuSet(Set<Hoadondichvu> hoadondichvuSet) {
        this.hoadondichvuSet = hoadondichvuSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDV != null ? maDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dichvu)) {
            return false;
        }
        Dichvu other = (Dichvu) object;
        if ((this.maDV == null && other.maDV != null) || (this.maDV != null && !this.maDV.equals(other.maDV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Dichvu[ maDV=" + maDV + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<CommentDichvu> getCommentDichvuSet() {
        return commentDichvuSet;
    }

    public void setCommentDichvuSet(Set<CommentDichvu> commentDichvuSet) {
        this.commentDichvuSet = commentDichvuSet;
    }
    
}
