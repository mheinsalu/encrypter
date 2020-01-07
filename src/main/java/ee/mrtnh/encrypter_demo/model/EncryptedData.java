package ee.mrtnh.encrypter_demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// An entity represents a table stored in a database.
// Every instance of an entity represents a row in the table.
// Spring generates tables based on classes with @Entity
@Entity
public class EncryptedData {

    private String encryptedData;
    private String userName;

    @Id
    @GeneratedValue
    private Long id;

    public EncryptedData() {
        this.encryptedData = "noData";
        this.userName = "default";
    }

    public EncryptedData(String encryptedData, String userName) {
        this.encryptedData = encryptedData;
        this.userName = userName;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }
        /* Check if o is an instance of EncryptedData or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof EncryptedData)) {
            return false;
        }
        // typecast o to EncryptedData so that we can compare data members
        EncryptedData data = (EncryptedData) obj;
        // Compare the data members and return accordingly
        if (getUserName().compareTo(data.getUserName()) == 0 && getEncryptedData().compareTo(data.getEncryptedData()) == 0) {
            return true;
        }
        return false;
    }
}

