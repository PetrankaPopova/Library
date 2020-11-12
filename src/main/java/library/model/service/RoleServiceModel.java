package library.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RoleServiceModel {

    private String authority;

    public RoleServiceModel() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
