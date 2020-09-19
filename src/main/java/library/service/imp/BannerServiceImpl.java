package library.service.imp;

import library.model.entity.Banner;
import library.model.service.BannerServiceModel;
import library.repository.BannerRepository;
import library.service.BannerService;
import org.modelmapper.ModelMapper;

public class BannerServiceImpl implements BannerService {

    private final ModelMapper modelMapper;
    private final BannerRepository bannnerRepository;

    public BannerServiceImpl(ModelMapper modelMapper, BannerRepository bannnerRepository) {
        this.modelMapper = modelMapper;
        this.bannnerRepository = bannnerRepository;
    }


    @Override
    public BannerServiceModel add(BannerServiceModel bannerServiceModel) {
        return null;
    }

    @Override
    public BannerServiceModel edit(BannerServiceModel bannerServiceModel) {
        return null;
    }

    @Override
    public BannerServiceModel delete(BannerServiceModel bannerServiceModel) {
        return null;
    }

    @Override
    public Banner findByCompanyName(String name) {
        return this.bannnerRepository.findByCompanyName(name).orElse(null);
    }
}
