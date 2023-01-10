package app.models.dto;

public class UserInfo {
    private final String username;
    private final String email;
    private final String phone;
    private final String address;

    public UserInfo(String username, String email, String phone, String address) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
