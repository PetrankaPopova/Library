package library.service;

import library.model.entity.Banner;
import library.model.service.BannerServiceModel;
import library.model.views.BannerViewModel;

import java.util.List;


public interface BannerService {


    void add(BannerServiceModel bannerServiceModel);

    BannerServiceModel edit(BannerServiceModel bannerServiceModel);

    void delete(String id);

    Banner findByCompanyName(String name);

    List<BannerViewModel> findAllItems();

}
