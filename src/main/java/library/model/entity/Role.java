package library.model.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements Serializable{

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role() {
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole erole) {
        this.name = erole;
    }
}
