/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Troels
 */
@Entity
@Table(name = "rented")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rented.findAll", query = "SELECT r FROM Rented r"),
    @NamedQuery(name = "Rented.findByIdrenting", query = "SELECT r FROM Rented r WHERE r.idrenting = :idrenting"),
    @NamedQuery(name = "Rented.findByState", query = "SELECT r FROM Rented r WHERE r.state = :state"),
    @NamedQuery(name = "Rented.findByDate", query = "SELECT r FROM Rented r WHERE r.date = :date")})
public class Rented implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrenting")
    private Integer idrenting;
    @Column(name = "state")
    private Boolean state;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "idlocation", referencedColumnName = "idlocation")
    @ManyToOne
    private Location idlocation;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Users username;

    public Rented() {
    }

    public Rented(Integer idrenting) {
        this.idrenting = idrenting;
    }

    public Integer getIdrenting() {
        return idrenting;
    }

    public void setIdrenting(Integer idrenting) {
        this.idrenting = idrenting;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(Location idlocation) {
        this.idlocation = idlocation;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrenting != null ? idrenting.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rented)) {
            return false;
        }
        Rented other = (Rented) object;
        if ((this.idrenting == null && other.idrenting != null) || (this.idrenting != null && !this.idrenting.equals(other.idrenting))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rented[ idrenting=" + idrenting + " ]";
    }
    
}
