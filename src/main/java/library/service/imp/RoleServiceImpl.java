package library.service.imp;

import library.model.entity.Authority;
import library.repository.RoleRepository;
import library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRolesToDb() {
        if (this.roleRepository.count() == 0) {
            this.roleRepository.saveAndFlush(new Authority("ADMIN"));
            this.roleRepository.saveAndFlush(new Authority("USER"));
        }
    }


}
