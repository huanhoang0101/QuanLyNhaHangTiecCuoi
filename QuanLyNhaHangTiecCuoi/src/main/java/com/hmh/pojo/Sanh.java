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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "sanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanh.findAll", query = "SELECT s FROM Sanh s"),
    @NamedQuery(name = "Sanh.findByMaSanh", query = "SELECT s FROM Sanh s WHERE s.maSanh = :maSanh"),
    @NamedQuery(name = "Sanh.findByTen", query = "SELECT s FROM Sanh s WHERE s.ten = :ten"),
    @NamedQuery(name = "Sanh.findBySoBan", query = "SELECT s FROM Sanh s WHERE s.soBan = :soBan"),
    @NamedQuery(name = "Sanh.findByImage", query = "SELECT s FROM Sanh s WHERE s.image = :image")})
public class Sanh implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45, message = "{sanh.name.err}")
    @Column(name = "Ten")
    private String ten;
    @Size(max = 45)
    @Column(name = "SoBan")
    private String soBan;
    @Size(max = 1000)
    @Column(name = "image")
    @NotNull(message = "{sanh.image.err}")
    private String image;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanhId")
    private Set<CommentSanh> commentSanhSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSanh")
    private Integer maSanh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanhMaSanh")
    @JsonIgnore
    private Set<Chitietsanh> chitietsanhSet;
    @Transient
    private MultipartFile file; 

    public Sanh() {
    }

    public Sanh(Integer maSanh) {
        this.maSanh = maSanh;
    }

    public Sanh(Integer maSanh, String ten) {
        this.maSanh = maSanh;
        this.ten = ten;
    }

    public Integer getMaSanh() {
        return maSanh;
    }

    public void setMaSanh(Integer maSanh) {
        this.maSanh = maSanh;
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
        hash += (maSanh != null ? maSanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanh)) {
            return false;
        }
        Sanh other = (Sanh) object;
        if ((this.maSanh == null && other.maSanh != null) || (this.maSanh != null && !this.maSanh.equals(other.maSanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Sanh[ maSanh=" + maSanh + " ]";
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<CommentSanh> getCommentSanhSet() {
        return commentSanhSet;
    }

    public void setCommentSanhSet(Set<CommentSanh> commentSanhSet) {
        this.commentSanhSet = commentSanhSet;
    }
}
