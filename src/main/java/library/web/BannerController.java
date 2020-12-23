package library.web;

import library.model.views.BannerViewModel;
import library.service.BannerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/banner")
public class BannerController {

    private final BannerService bannerService;
    private final ModelMapper modelMapper;

    @Autowired
    public BannerController(BannerService bannerService, ModelMapper modelMapper) {
        this.bannerService = bannerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BannerViewModel>> getAllBanners(){
        List<BannerViewModel> banners = this.bannerService.findAllItems().stream().map(bannerServiceModel ->
                this.modelMapper.map(bannerServiceModel, BannerViewModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(banners, HttpStatus.OK);
    }

    //todo
    //methods

}
