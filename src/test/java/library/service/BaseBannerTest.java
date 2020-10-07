package library.service;

import library.model.entity.Banner;
import library.model.service.BannerServiceModel;


public abstract class BaseBannerTest {

    protected static Banner getBannerfromDb() {
        Banner banner = new Banner();
        banner.setCompanyName("Hard Solution");
        return banner;
    }

    protected static BannerServiceModel getBannerServiceModel() {
        BannerServiceModel bannerServiceModel = new BannerServiceModel();
        bannerServiceModel.setCompanyName("Hard Solution");
        return bannerServiceModel;
    }



}
