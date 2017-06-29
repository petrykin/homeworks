package lesson16.task2.controller;

import lesson16.task2.model.Category;
import lesson16.task2.model.CategoryDAO;

import java.util.Set;

public class CategoryController {
    public static Set<Category> categories() {
        return new CategoryDAO().getAll();
    }
}
