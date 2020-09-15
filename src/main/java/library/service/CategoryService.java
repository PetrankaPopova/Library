package library.service;

import library.model.entity.Category;
import library.model.service.CategoryServiceModel;

public interface CategoryService {

    void addDefaultCate();

    CategoryServiceModel getCategoryById(String id);

    CategoryServiceModel getCategoryByName(String categoryName);

    CategoryServiceModel getAllCategories();
}
