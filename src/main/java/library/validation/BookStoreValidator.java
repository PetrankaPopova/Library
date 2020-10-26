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
                    String.format(ValidationConstants.ALREADY_EXISTS, bookStoreBindingModel.getStoreName()),
                    String.format(ValidationConstants.ALREADY_EXISTS, bookStoreBindingModel.getStoreName())
            );
        }


        if (this.bookStoreRepository.findBookStoreByStorePhoneNumber(bookStoreBindingModel.getStorePhoneNumber())
                .isPresent()) {
            errors.rejectValue("bookstore",
                    String.format(ValidationConstants.ALREADY_EXISTS, bookStoreBindingModel.getStoreName()),
                    String.format(ValidationConstants.ALREADY_EXISTS, bookStoreBindingModel.getStoreName())
            );
        }


        if (this.bookStoreRepository.findBookStoreByVatNumber(bookStoreBindingModel.getVatNumber())
                .isPresent()) {
            errors.rejectValue("bookstore",
                    String.format(ValidationConstants.ALREADY_EXISTS, bookStoreBindingModel.getStoreName()),
                    String.format(ValidationConstants.ALREADY_EXISTS, bookStoreBindingModel.getStoreName())
            );
        }

        if (bookStoreBindingModel.getStoreName().length() < 3 ||
                bookStoreBindingModel.getStoreName().length() > 20) {
            errors.rejectValue("bookStoreName",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getStoreName()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getStoreName())

            );
        }


        if (bookStoreBindingModel.getCity().isEmpty()) {
            errors.rejectValue("city",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getCity()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getCity())
            );
        }

        if (bookStoreBindingModel.getCountry().isEmpty()) {
            errors.rejectValue("country",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getCountry()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getCountry())

            );
        }

        if (bookStoreBindingModel.getPostCode().isEmpty()) {
            errors.rejectValue("postcode",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getPostCode()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getPostCode())

            );
        }

        if (bookStoreBindingModel.getStorePhoneNumber().length() < 3 ||
                bookStoreBindingModel.getStorePhoneNumber().length() > 20) {
            errors.rejectValue("phoneNumber",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getStorePhoneNumber()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getStoreName())

            );
        }

        if (bookStoreBindingModel.getRegion().length() < 3 ||
                bookStoreBindingModel.getRegion().length() > 20) {
            errors.rejectValue("region",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getRegion()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getRegion())

            );
        }

        if (bookStoreBindingModel.getStreetAddress().length() < 3 ||
                bookStoreBindingModel.getStreetAddress().length() > 20) {
            errors.rejectValue("streetAddress",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getStreetAddress()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getStreetAddress())

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
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getVatNumber()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getVatNumber())

            );
        }

        if (bookStoreBindingModel.getInformation().isEmpty()) {
            errors.rejectValue("information",
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getInformation()),
                    String.format(ValidationConstants.NAME_LENGTH, bookStoreBindingModel.getInformation())

            );
        }


    }
}
