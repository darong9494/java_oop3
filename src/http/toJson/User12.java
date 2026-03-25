package http.toJson;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User12 {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private  String website;
    private Company company;

    public User12() {
        address = new Address();
        company = new Company();
    }

}


