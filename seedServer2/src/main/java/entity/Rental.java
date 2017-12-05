package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "rental")
@XmlRootElement

public class Rental implements Serializable{    
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   @Column(name = "description")
   @Size(max = 1200)
   private String description;
   
    @Column(name = "city")
   @Size(max = 50)
   private String city;
    
    @Column(name = "zip")
    private String zip;
   
   @Column(name = "street")
   @Size(max = 50)
   private String street;
   
   @Column(name = "streetNumber")
   @Size(max = 4)
   private Integer streetNumber;
   
   @Column(name = "rating")
   @Size(max = 1)
   private Integer rating;
   
   @Column(name = "latitude")
   private Float latitude;
   
   @Column(name = "longitude")
   private Float longitude;
   
   @Column(name = "userName")
   private String userName;

    public Rental() {
    }

    public Rental(Long id, String description, String city, String zip, String street, Integer streetNumber, Integer rating, Float latitude, Float longitude, String userName) {
        this.id = id;
        this.description = description;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.streetNumber = streetNumber;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.city);
        hash = 83 * hash + Objects.hashCode(this.zip);
        hash = 83 * hash + Objects.hashCode(this.street);
        hash = 83 * hash + Objects.hashCode(this.streetNumber);
        hash = 83 * hash + Objects.hashCode(this.rating);
        hash = 83 * hash + Objects.hashCode(this.latitude);
        hash = 83 * hash + Objects.hashCode(this.longitude);
        hash = 83 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rental other = (Rental) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.streetNumber, other.streetNumber)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        if (!Objects.equals(this.longitude, other.longitude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rental{" + "id=" + id + ", description=" + description + ", city=" + city + ", zip=" + zip + ", street=" + street + ", streetNumber=" + streetNumber + ", rating=" + rating + ", latitude=" + latitude + ", longitude=" + longitude + ", userName=" + userName + '}';
    }
 
    
}