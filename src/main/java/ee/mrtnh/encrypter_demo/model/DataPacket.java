package ee.mrtnh.encrypter_demo.model;

public class DataPacket {

    private String data;
    private String user;
    private String password;

    public DataPacket() {
        // Class 'DataPacket' should have public no-arg constructor
        this.data = "data";
        this.user = "default";
        this.password = "default";
    }

    public DataPacket(String data, String user, String password) {
        this.data = data;
        this.user = user;
        this.password = password;
    }

    public DataPacket(String data, DataPacket dataPacket) {
        this.data = data;
        this.user = dataPacket.getUser();
        this.password = dataPacket.getPassword();
    }

    @Override
    public String toString() {
        return "Data " + this.data + " from user " + this.user;
    }

    public String getData() {
        return data;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
