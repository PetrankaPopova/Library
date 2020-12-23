package library.model.bindingmodel;

import library.constant.GlobalConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

import static library.constant.GlobalConstants.*;

@Setter
@Getter
@NoArgsConstructor
public class AuthorBindingModel {

    @Pattern(regexp = AUTHOR_NAME_REGEX, message = GlobalConstants.AUTHOR_NAME_IS_NULL_OR_EMPTY)
    private String name;
    @Pattern(regexp = AUTHOR_IMAGE_URL_REGEX, message = AUTHOR_IMAGE_URL_IS_NULL_OR_EMPTY)
    private String imageUrl;
}
