package library.model.bindingmodel;

import library.constant.GlobalConstants;

import javax.validation.constraints.Pattern;

import static library.constant.GlobalConstants.*;

public class AuthorBindingModel {

    private String name;
    private String imageUrl;

    public AuthorBindingModel() {
    }

    @Pattern(regexp = AUTHOR_NAME_REGEX, message = GlobalConstants.AUTHOR_NAME_IS_NULL_OR_EMPTY)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Pattern(regexp = AUTHOR_IMAGE_URL_REGEX, message = AUTHOR_IMAGE_URL_IS_NULL_OR_EMPTY)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
