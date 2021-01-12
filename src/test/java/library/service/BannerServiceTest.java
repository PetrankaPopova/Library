package library.service;


import library.model.entity.Banner;
import library.model.service.BannerServiceModel;
import library.repository.BannerRepository;
import library.service.imp.BannerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class BannerServiceTest {

    @MockBean
    BannerRepository mockedBannerRepository;
    @InjectMocks
    BannerServiceImpl bannerServiceImpl;
    @Autowired
  //  ModelMapper modelMapper;

   // private Banner bannerFromDb;
   // private BannerServiceModel bannerServiceModel;

    @BeforeEach
    void setUp() {
    //    this.bannerServiceImpl = new BannerServiceImpl(this.modelMapper,this.mockedBannerRepository);
    //    this.bannerFromDb = BaseBannerTest.getBannerfromDb();
   //     this.bannerServiceModel = BaseBannerTest.getBannerServiceModel();
    }

    @AfterEach
    void tearDown() {
   //    this.bannerServiceImpl = null;
    //    this.bannerFromDb = null;
    //    this.bannerServiceModel = null;
    }
    @Test
    public  void addBanner_Correct(){
       // Mockito.when(this.mockedBannerRepository.saveAndFlush(Mockito.any()))
       //         .thenReturn(this.bannerFromDb);
      //  Banner banner = this.modelMapper.map(bannerServiceModel, Banner.class);
      //  Banner bannerFromDB = this.mockedBannerRepository.saveAndFlush(banner);
       // BannerServiceModel realBanner = this.modelMapper.map(bannerFromDB, BannerServiceModel.class);
       // BannerServiceModel whatMustBe = this.bannerServiceImpl.
         //       addBanner(this.bannerServiceModel);
       // Assertions.assertEquals(whatMustBe.getCompanyName(), realBanner.getCompanyName());
    }
//    @Test
//    public  void deleteBanner_Correctly(){
//        Mockito.when(this.mockedBannerRepository.saveAndFlush(Mockito.any()))
//                .thenReturn(this.bannerFromDb);
//        Banner banner = this.modelMapper.map(bannerServiceModel, Banner.class);
//        Banner bannerFromDB = this.mockedBannerRepository.saveAndFlush(banner);
//        BannerServiceModel realBanner = this.modelMapper.map(bannerFromDB, BannerServiceModel.class);
//        BannerServiceModel whatMustBe = this.bannerServiceImpl.
//                addBanner(this.bannerServiceModel);
//        Assertions.assertEquals(whatMustBe.getCompanyName(), realBanner.getCompanyName());
//    }

}