package library.service;

import library.model.service.CategoryServiceModel;

public interface CategoryService {

    void addDefaultCategory();

    CategoryServiceModel getCategoryById(String id);

    CategoryServiceModel getCategoryByName(String categoryName);

    CategoryServiceModel getAllCategories();
}
