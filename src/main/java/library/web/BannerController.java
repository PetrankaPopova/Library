package library.web;

import library.model.views.BannerViewModel;
import library.service.BannerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BannerController {

    private final BannerService bannerService;
    private final ModelMapper modelMapper;

    @Autowired
    public BannerController(BannerService bannerService, ModelMapper modelMapper) {
        this.bannerService = bannerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/banner/all")
    public List<BannerViewModel> getAllBanners(){
        return this.bannerService.findAllItems().stream().map(bannerServiceModel ->
                this.modelMapper.map(bannerServiceModel, BannerViewModel.class))
                .collect(Collectors.toList());
    }



}
