package library.repository;

import library.model.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, String> {

    Optional<Banner> findByCompanyName (String name);
}
