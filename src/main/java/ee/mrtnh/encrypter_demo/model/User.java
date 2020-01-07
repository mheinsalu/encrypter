package ee.mrtnh.encrypter_demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    private String userName;
    private String password;

    @Id
    @GeneratedValue
    private Long userId;

    public User() {
        this.userName = "default";
        this.password = "default";
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }
        /* Check if o is an instance of EncryptedData or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof User)) {
            return false;
        }
        // typecast o to EncryptedData so that we can compare data members
        User user = (User) obj;
        // Compare the data members and return accordingly
        if (getUserName().compareTo(user.getUserName()) == 0 && getPassword().compareTo(user.getPassword()) == 0) {
            return true;
        }
        return false;
    }
}
