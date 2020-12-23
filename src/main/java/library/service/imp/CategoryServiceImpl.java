package library.service.imp;

import library.model.entity.BookCategoryEnum;
import library.model.entity.Category;
import library.model.service.CategoryServiceModel;
import library.repository.CategoryRepository;
import library.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @PostConstruct
    public void addDefaultCategory() {
        if (this.categoryRepository.count() == 0){
            for (BookCategoryEnum value : BookCategoryEnum.values()) {
                this.categoryRepository.saveAndFlush(new Category(value.getCategoryName(), value.getDescription()));
            }
        }
    }

    @Override
    public CategoryServiceModel getCategoryById(String id) {
        //todo
        return null;
    }

    @Override
    public CategoryServiceModel getCategoryByName(String categoryName) {
        //todo
        return null;
    }

    @Override
    public CategoryServiceModel getAllCategories() {
        //todo
        return null;
    }
}
