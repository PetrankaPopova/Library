package library.validation;

import library.model.bindingmodel.BannerAddBindingModel;
import library.repository.BannerRepository;
import org.springframework.validation.Errors;

@Validator
public class BannerAddValidator implements org.springframework.validation.Validator {

   private final BannerRepository bannerRepository;

    public BannerAddValidator(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

        @Override
        public void validate(Object o, Errors errors) {
            BannerAddBindingModel bannerAddBindingModel = (BannerAddBindingModel) o;

            if (this.bannerRepository.findByCompanyName(bannerAddBindingModel.getCompanyName()).isPresent()) {
                errors.rejectValue("companyName",
                        String.format(ValidationConstants.ALREADY_EXISTS, bannerAddBindingModel.getCompanyName()),
                        String.format(ValidationConstants.ALREADY_EXISTS, bannerAddBindingModel.getCompanyName())
                );
            }

            if (bannerAddBindingModel.getPrice() <=   0) {
                errors.rejectValue("price",
                        ValidationConstants.PRICE_NEGATIVE,
                        ValidationConstants.PRICE_NEGATIVE
                );
            }


        }
    @Override
    public boolean supports(Class<?> aClass) {
        return BannerAddBindingModel.class.equals(aClass);    }

}






