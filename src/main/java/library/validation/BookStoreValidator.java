package library.validation;


import library.model.bindingmodel.BookStoreBindingModel;
import library.repository.BookStoreRepository;
import org.springframework.validation.Errors;

@Validator
public class BookStoreValidator implements org.springframework.validation.Validator  {

    private  final BookStoreRepository bookStoreRepository;

    public BookStoreValidator(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BookStoreBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookStoreBindingModel bookStoreBindingModel = (BookStoreBindingModel) o;

        if (this.bookStoreRepository.findBookStoreByStoreName(bookStoreBindingModel.getStoreName())
                .isPresent()) {
            errors.rejectValue("bookstore",
                    String.format(ValidationConstants.ALREADY_EXISTS, "Book store"),
                    String.format(ValidationConstants.ALREADY_EXISTS, "Book store")
            );
        }


        if (this.bookStoreRepository.findBookStoreByStorePhoneNumber(bookStoreBindingModel.getStorePhoneNumber())
                .isPresent()) {
            errors.rejectValue("phoneNumber",
                    String.format(ValidationConstants.ALREADY_EXISTS, "Phone number"),
                    String.format(ValidationConstants.ALREADY_EXISTS, "Phone number")
            );
        }


        if (this.bookStoreRepository.findBookStoreByVatNumber(bookStoreBindingModel.getVatNumber())
                .isPresent()) {
            errors.rejectValue("vatNumber",
                    String.format(ValidationConstants.ALREADY_EXISTS, "Vat number"),
                    String.format(ValidationConstants.ALREADY_EXISTS, "Vat number")
            );
        }

        if (bookStoreBindingModel.getStoreName().length() < 3 ||
                bookStoreBindingModel.getStoreName().length() > 20) {
            errors.rejectValue("bookStoreName",
                    String.format(ValidationConstants.NAME_LENGTH, "Store name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Store name")

            );
        }


        if (bookStoreBindingModel.getCity().isEmpty()) {
            errors.rejectValue("city",
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "City"),
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "City")
            );
        }

        if (bookStoreBindingModel.getCountry().isEmpty()) {
            errors.rejectValue("country",
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "Country"),
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "Country")

            );
        }

        if (bookStoreBindingModel.getPostCode().isEmpty()) {
            errors.rejectValue("postcode",
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "Postcode"),
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "Postcode")

            );
        }

        if (bookStoreBindingModel.getStorePhoneNumber().length() < 3 ||
                bookStoreBindingModel.getStorePhoneNumber().length() > 20) {
            errors.rejectValue("phoneNumber",
                    String.format(ValidationConstants.NAME_LENGTH, "Phone number"),
                    String.format(ValidationConstants.NAME_LENGTH, "Phone number")

            );
        }

        if (bookStoreBindingModel.getRegion().length() < 3 ||
                bookStoreBindingModel.getRegion().length() > 20) {
            errors.rejectValue("region",
                    String.format(ValidationConstants.NAME_LENGTH, "Region"),
                    String.format(ValidationConstants.NAME_LENGTH, "Region")

            );
        }

        if (bookStoreBindingModel.getStreetAddress().length() < 3 ||
                bookStoreBindingModel.getStreetAddress().length() > 20) {
            errors.rejectValue("streetAddress",
                    String.format(ValidationConstants.NAME_LENGTH, "Street address"),
                    String.format(ValidationConstants.NAME_LENGTH, "Street address")

            );
        }

        if (bookStoreBindingModel.getStreetNumber().length() < 1 ||
                bookStoreBindingModel.getStreetNumber().length() > 20) {
            errors.rejectValue("bookstoreStreetNumber",
                    ValidationConstants.STREET_NUMBER,
                    ValidationConstants.STREET_NUMBER
            );
        }

        if (bookStoreBindingModel.getVatNumber().length() < 3 ||
                bookStoreBindingModel.getVatNumber().length() > 20) {
            errors.rejectValue("bookstoreVatNumber",
                    String.format(ValidationConstants.NAME_LENGTH, "Vat number"),
                    String.format(ValidationConstants.NAME_LENGTH, "Vat number")

            );
        }

        if (bookStoreBindingModel.getInformation().isEmpty()) {
            errors.rejectValue("information",
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "Information"),
                    String.format(ValidationConstants.CAN_NOT_BE_EMPTY, "Information")

            );
        }


    }
}
