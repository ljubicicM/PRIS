package Backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class ArtPiece {
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
    private int yearCreated;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @OneToMany(mappedBy = "artPiece")
    private List<Request> requests;

    @ManyToOne
    private ArtisticMovement artisticMovement;

    @ManyToOne
    private Epoch epoch;

    @ManyToOne
    private Author author;

    @ManyToMany
    @JoinTable(name = "artpiece_route", joinColumns = @JoinColumn(name = "artpiece_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;

    public ArtPiece() {
        super();
    }

    public ArtPiece(String name, String address, String description, int xCoordinate, int yCoordinate,
            int retentionTime, int yearCreated, byte[] image) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.retentionTime = retentionTime;
        this.yearCreated = yearCreated;
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

    public int getyearCreated() {
        return yearCreated;
    }

    public void setyearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public ArtisticMovement getArtisticMovement() {
        return artisticMovement;
    }

    public void setArtisticMovement(ArtisticMovement artisticMovement) {
        this.artisticMovement = artisticMovement;
    }

    public Epoch getEpoch() {
        return epoch;
    }

    public void setEpoch(Epoch epoch) {
        this.epoch = epoch;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
