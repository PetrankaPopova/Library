package library.validation;

import library.model.bindingmodel.BookBindingModel;
import library.repository.BookRepository;
import org.springframework.validation.Errors;

@Validator
public class BookAddValidator implements org.springframework.validation.Validator {
    private final BookRepository bookRepository;

    public BookAddValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
            return BookBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookBindingModel bookBindingModel = (BookBindingModel) o;


        if (bookBindingModel.getTitle().length() < 3 ||
                bookBindingModel.getTitle().length() > 20) {
            errors.rejectValue("title",
                    String.format(ValidationConstants.NAME_LENGTH, "Title"),
                    String.format(ValidationConstants.NAME_LENGTH, "Title")
            );
        }

        if (bookBindingModel.getContent().length() < 3 ||
                bookBindingModel.getContent().length() > 20) {
            errors.rejectValue("content",
                    String.format(ValidationConstants.NAME_LENGTH, "Content"),
                    String.format(ValidationConstants.NAME_LENGTH, "Content")
            );
        }

        if (bookBindingModel.getLanguage().length() < 3 ||
                bookBindingModel.getLanguage().length() > 20) {
            errors.rejectValue("language",
                    String.format(ValidationConstants.NAME_LENGTH, "Language"),
                    String.format(ValidationConstants.NAME_LENGTH, "Language")
            );
        }


        if (bookBindingModel.getYearOfIssue().length() < 3 ||
                bookBindingModel.getYearOfIssue().length() > 20) {
            errors.rejectValue("yearOfIssue",
                    String.format(ValidationConstants.NAME_LENGTH, "Year of issue"),
                    String.format(ValidationConstants.NAME_LENGTH, "Year of issue")
            );
        }

        if (bookBindingModel.getPublishingHouse().length() < 3 ||
                bookBindingModel.getPublishingHouse().length() > 20) {
            errors.rejectValue("publishingHouse",
                    String.format(ValidationConstants.NAME_LENGTH, "Publishing house"),
                    String.format(ValidationConstants.NAME_LENGTH, "Publishing house")
            );
        }


        if (bookBindingModel.getCoverType().length() < 3 ||
                bookBindingModel.getCoverType().length() > 20) {
            errors.rejectValue("coverType",
                    String.format(ValidationConstants.NAME_LENGTH, "Cover type"),
                    String.format(ValidationConstants.NAME_LENGTH, "Cover type")
            );
        }

        if (bookBindingModel.getDescription().length() < 3 ||
                bookBindingModel.getDescription().length() > 20) {
            errors.rejectValue("description",
                    String.format(ValidationConstants.NAME_LENGTH, "Description"),
                    String.format(ValidationConstants.NAME_LENGTH, "Description")
            );
        }

        if (bookBindingModel.getIsbn().length() < 3 ||
                bookBindingModel.getIsbn().length() > 20) {
            errors.rejectValue("isbn",
                    String.format(ValidationConstants.NAME_LENGTH, "Isbn"),
                    String.format(ValidationConstants.NAME_LENGTH, "Isbn")
            );
        }

        if (bookBindingModel.getRating() <= 0) {
            errors.rejectValue("rating",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Rating"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Rating")
            );
        }

        /*if (bookBindingModel.getWidth() <= 0) {
            errors.rejectValue("width",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Width"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Width")
            );
        }

        if (bookBindingModel.getWeight() <= 0) {
            errors.rejectValue("weight",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Weight"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Weight")
            );
        }

        if (bookBindingModel.getLength() <= 0) {
            errors.rejectValue("length",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Length"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Length")
            );
        }*/


    }
}
