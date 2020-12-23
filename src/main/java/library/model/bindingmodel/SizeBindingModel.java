package library.model.bindingmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SizeBindingModel {
    private int length;
    private int width;
    private int height;
    private int weight;

}
