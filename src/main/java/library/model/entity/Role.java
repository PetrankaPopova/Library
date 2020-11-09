package library.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@SuppressWarnings("ALL")
@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority, Serializable {

    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

