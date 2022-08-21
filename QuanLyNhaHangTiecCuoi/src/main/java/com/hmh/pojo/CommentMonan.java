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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comment_monan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentMonan.findAll", query = "SELECT c FROM CommentMonan c"),
    @NamedQuery(name = "CommentMonan.findById", query = "SELECT c FROM CommentMonan c WHERE c.id = :id"),
    @NamedQuery(name = "CommentMonan.findByContent", query = "SELECT c FROM CommentMonan c WHERE c.content = :content"),
    @NamedQuery(name = "CommentMonan.findByCreatedDate", query = "SELECT c FROM CommentMonan c WHERE c.createdDate = :createdDate")})
public class CommentMonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "user_id", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Khachhang userId;
    @JoinColumn(name = "monan_id", referencedColumnName = "MaMenu")
    @ManyToOne(optional = false)
    private Menu monanId;

    public CommentMonan() {
    }

    public CommentMonan(Integer id) {
        this.id = id;
    }

    public CommentMonan(Integer id, String content, Date createdDate) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Khachhang getUserId() {
        return userId;
    }

    public void setUserId(Khachhang userId) {
        this.userId = userId;
    }

    public Menu getMonanId() {
        return monanId;
    }

    public void setMonanId(Menu monanId) {
        this.monanId = monanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentMonan)) {
            return false;
        }
        CommentMonan other = (CommentMonan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.CommentMonan[ id=" + id + " ]";
    }
    
}
