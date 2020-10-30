package library.validation;

import library.model.bindingmodel.BookAddBindingModel;
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
            return BookAddBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookAddBindingModel bookAddBindingModel = (BookAddBindingModel) o;


        if (bookAddBindingModel.getTitle().length() < 3 ||
                bookAddBindingModel.getTitle().length() > 20) {
            errors.rejectValue("title",
                    String.format(ValidationConstants.NAME_LENGTH, "Title"),
                    String.format(ValidationConstants.NAME_LENGTH, "Title")
            );
        }

        if (bookAddBindingModel.getContent().length() < 3 ||
                bookAddBindingModel.getContent().length() > 20) {
            errors.rejectValue("content",
                    String.format(ValidationConstants.NAME_LENGTH, "Content"),
                    String.format(ValidationConstants.NAME_LENGTH, "Content")
            );
        }

        if (bookAddBindingModel.getLanguage().length() < 3 ||
                bookAddBindingModel.getLanguage().length() > 20) {
            errors.rejectValue("language",
                    String.format(ValidationConstants.NAME_LENGTH, "Language"),
                    String.format(ValidationConstants.NAME_LENGTH, "Language")
            );
        }


        if (bookAddBindingModel.getYearOfIssue().length() < 3 ||
                bookAddBindingModel.getYearOfIssue().length() > 20) {
            errors.rejectValue("yearOfIssue",
                    String.format(ValidationConstants.NAME_LENGTH, "Year of issue"),
                    String.format(ValidationConstants.NAME_LENGTH, "Year of issue")
            );
        }

        if (bookAddBindingModel.getPublishingHouse().length() < 3 ||
                bookAddBindingModel.getPublishingHouse().length() > 20) {
            errors.rejectValue("publishingHouse",
                    String.format(ValidationConstants.NAME_LENGTH, "Publishing house"),
                    String.format(ValidationConstants.NAME_LENGTH, "Publishing house")
            );
        }


        if (bookAddBindingModel.getCoverType().length() < 3 ||
                bookAddBindingModel.getCoverType().length() > 20) {
            errors.rejectValue("coverType",
                    String.format(ValidationConstants.NAME_LENGTH, "Cover type"),
                    String.format(ValidationConstants.NAME_LENGTH, "Cover type")
            );
        }

        if (bookAddBindingModel.getDescription().length() < 3 ||
                bookAddBindingModel.getDescription().length() > 20) {
            errors.rejectValue("description",
                    String.format(ValidationConstants.NAME_LENGTH, "Description"),
                    String.format(ValidationConstants.NAME_LENGTH, "Description")
            );
        }

        if (bookAddBindingModel.getIsbn().length() < 3 ||
                bookAddBindingModel.getIsbn().length() > 20) {
            errors.rejectValue("isbn",
                    String.format(ValidationConstants.NAME_LENGTH, "Isbn"),
                    String.format(ValidationConstants.NAME_LENGTH, "Isbn")
            );
        }

        if (bookAddBindingModel.getRating() <= 0) {
            errors.rejectValue("rating",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Rating"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Rating")
            );
        }

        if (bookAddBindingModel.getWidth() <= 0) {
            errors.rejectValue("width",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Width"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Width")
            );
        }

        if (bookAddBindingModel.getWeight() <= 0) {
            errors.rejectValue("weight",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Weight"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Weight")
            );
        }

        if (bookAddBindingModel.getLength() <= 0) {
            errors.rejectValue("length",
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Length"),
                    String.format(ValidationConstants.NUMBER_NEGATIVE, "Length")
            );
        }


    }
}
