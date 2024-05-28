package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String emailUser;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUser;

    private String passwordUser;

    private String phoneUser;

    private String roleUser;

    private String usernameUser;

    public User() {
    }

    public String getEmailUser() {
        return this.emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

}