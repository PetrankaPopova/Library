package library.service.imp;

import library.model.service.CategoryServiceModel;
import library.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public void addDefaultCate() {

    }

    @Override
    public CategoryServiceModel getCategoryById(String id) {
        return null;
    }

    @Override
    public CategoryServiceModel getCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public CategoryServiceModel getAllCategories() {
        return null;
    }
}
