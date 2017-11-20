/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author Troels
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdlocation", query = "SELECT l FROM Location l WHERE l.idlocation = :idlocation"),
    @NamedQuery(name = "Location.findByDescription", query = "SELECT l FROM Location l WHERE l.description = :description"),
    @NamedQuery(name = "Location.findByStreet", query = "SELECT l FROM Location l WHERE l.street = :street"),
    @NamedQuery(name = "Location.findByHousenr", query = "SELECT l FROM Location l WHERE l.housenr = :housenr")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlocation")
    private Integer idlocation;
    @Size(max = 1500)
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "img")
    private byte[] img;
    @Size(max = 45)
    @Column(name = "street")
    private String street;
    @Column(name = "housenr")
    private Integer housenr;
    @OneToMany(mappedBy = "idlocation")
    private Collection<Rented> rentedCollection;
    @JoinColumn(name = "zip", referencedColumnName = "zip")
    @ManyToOne
    private Cities zip;
    @JoinColumn(name = "idrating", referencedColumnName = "idrating")
    @ManyToOne
    private Ratings idrating;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Users username;

    public Location() {
    }

    public Location(Integer idlocation) {
        this.idlocation = idlocation;
    }

    public Integer getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(Integer idlocation) {
        this.idlocation = idlocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHousenr() {
        return housenr;
    }

    public void setHousenr(Integer housenr) {
        this.housenr = housenr;
    }

    @XmlTransient
    public Collection<Rented> getRentedCollection() {
        return rentedCollection;
    }

    public void setRentedCollection(Collection<Rented> rentedCollection) {
        this.rentedCollection = rentedCollection;
    }

    public Cities getZip() {
        return zip;
    }

    public void setZip(Cities zip) {
        this.zip = zip;
    }

    public Ratings getIdrating() {
        return idrating;
    }

    public void setIdrating(Ratings idrating) {
        this.idrating = idrating;
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
        hash += (idlocation != null ? idlocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idlocation == null && other.idlocation != null) || (this.idlocation != null && !this.idlocation.equals(other.idlocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Location[ idlocation=" + idlocation + " ]";
    }
    
}
