package library.service.imp;


import library.model.entity.Banner;
import library.model.service.BannerServiceModel;
import library.model.views.BannerViewModel;
import library.repository.BannerRepository;
import library.service.BannerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    private final ModelMapper modelMapper;
    private final BannerRepository bannerRepository;

    public BannerServiceImpl(ModelMapper modelMapper, BannerRepository bannerRepository) {
        this.modelMapper = modelMapper;
        this.bannerRepository = bannerRepository;
    }


    @Override
    public void add(BannerServiceModel bannerServiceModel) {
        Banner banner = this.modelMapper.map(bannerServiceModel, Banner.class);
        this.bannerRepository.saveAndFlush(banner);

    }

    @Override
    public BannerServiceModel edit(BannerServiceModel bannerServiceModel) {
        BannerServiceModel bsm = new BannerServiceModel();
        bsm.setPrice(bannerServiceModel.getPrice());
        bsm.setStartingDate(bannerServiceModel.getStartingDate());
        bsm.setEndingDate(bannerServiceModel.getEndingDate());
        bsm.setCompanyName(bannerServiceModel.getCompanyName());
        return bsm;
    }

    @Override
    public void delete(String id) {
        //todo
        this.bannerRepository.deleteById(id);
    }

    @Override
    public Banner findByCompanyName(String name) {
        return this.bannerRepository.findByCompanyName(name).orElse(null);
    }

    @Override
    public List<BannerViewModel> findAllItems() {
        //todo
        //review
        return this.bannerRepository.findAll().stream()
                .map(banner -> {
                    BannerViewModel bannerViewModel = this.modelMapper.map(banner, BannerViewModel.class);
                    bannerViewModel.setImgUrl(String.format("/img/%s-%s.jpg", banner.getCompanyName(), banner.getCount()));
                    return bannerViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public BannerServiceModel addBanner(BannerServiceModel bannerServiceModel) {
        Banner banner = this.modelMapper.map(bannerServiceModel, Banner.class);
        Banner bannerFromDb = this.bannerRepository.saveAndFlush(banner);
        return this.modelMapper.map(bannerFromDb, BannerServiceModel.class);
    }
}
