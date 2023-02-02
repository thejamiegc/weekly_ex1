package dtos;

public class DBUserDTO {
    String userName;
    String password;
    String connectionStr;

    public DBUserDTO(String userName, String password, String connectionStr) {
        this.userName = userName;
        this.password = password;
        this.connectionStr = connectionStr;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionStr() {
        return connectionStr;
    }

    public void setConnectionStr(String connectionStr) {
        this.connectionStr = connectionStr;
    }
}
