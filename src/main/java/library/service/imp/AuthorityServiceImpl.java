package library.service.imp;

import library.model.entity.Authority;
import library.repository.AuthorityRepository;
import library.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void seedRolesToDb() {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAndFlush(new Authority("ADMIN"));
            this.authorityRepository.saveAndFlush(new Authority("USER"));
        }
    }


}
