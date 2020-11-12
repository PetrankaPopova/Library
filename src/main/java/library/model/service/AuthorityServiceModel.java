package library.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AuthorityServiceModel {

    private String authority;

    public AuthorityServiceModel() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
