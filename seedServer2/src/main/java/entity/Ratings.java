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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Troels
 */
@Entity
@Table(name = "ratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r"),
    @NamedQuery(name = "Ratings.findByIdrating", query = "SELECT r FROM Ratings r WHERE r.idrating = :idrating"),
    @NamedQuery(name = "Ratings.findByRatingScore", query = "SELECT r FROM Ratings r WHERE r.ratingScore = :ratingScore")})
public class Ratings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrating")
    private Integer idrating;
    @Column(name = "rating_score")
    private Short ratingScore;
    @OneToMany(mappedBy = "idrating")
    private Collection<Location> locationCollection;

    public Ratings() {
    }

    public Ratings(Integer idrating) {
        this.idrating = idrating;
    }

    public Integer getIdrating() {
        return idrating;
    }

    public void setIdrating(Integer idrating) {
        this.idrating = idrating;
    }

    public Short getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Short ratingScore) {
        this.ratingScore = ratingScore;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrating != null ? idrating.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.idrating == null && other.idrating != null) || (this.idrating != null && !this.idrating.equals(other.idrating))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ratings[ idrating=" + idrating + " ]";
    }
    
}
