package backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    @Column(length = 5000)
    private String description;

    private int xCoordinate;
    private int yCoordinate;
    private int retentionTime;
    private int yearBuilt;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    public Landmark() {
        super();
    }

    public Landmark(String name, String address, String description, int xCoordinate, int yCoordinate,
            int retentionTime, int yearBuilt, byte[] image) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.retentionTime = retentionTime;
        this.yearBuilt = yearBuilt;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(int retentionTime) {
        this.retentionTime = retentionTime;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
