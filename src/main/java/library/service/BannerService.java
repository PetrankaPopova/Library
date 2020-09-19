package library.service;

import library.model.entity.Banner;
import library.model.service.BannerServiceModel;


public interface BannerService {


    BannerServiceModel add(BannerServiceModel bannerServiceModel);
    BannerServiceModel edit(BannerServiceModel bannerServiceModel);
    BannerServiceModel delete(BannerServiceModel bannerServiceModel);
    Banner findByCompanyName(String name);

}
