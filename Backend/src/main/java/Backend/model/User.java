package Backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String emailUser;

    private String passwordUser;

    private String phoneUser;

    private String roleUser;

    private String usernameUser;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Route> routes;

    public User() {
    }

    public User(String emailUser, String passwordUser, String phoneUser, String roleUser, String usernameUser) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.phoneUser = phoneUser;
        this.roleUser = roleUser;
        this.usernameUser = usernameUser;
    }

    public User(String emailUser, String passwordUser, String roleUser, String usernameUser) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
        this.usernameUser = usernameUser;
    }

    public String getEmailUser() {
        return this.emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getPasswordUser() {
        return this.passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getPhoneUser() {
        return this.phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getRoleUser() {
        return this.roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public String getUsernameUser() {
        return this.usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

}