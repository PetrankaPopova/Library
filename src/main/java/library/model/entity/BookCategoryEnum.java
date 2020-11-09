package library.model.entity;

public enum BookCategoryEnum {

    ART("Art"),
    APPLIED_PSYCHOLOGY("Applied psychology"),
    COMPUTERS("Computers"),
    ECONOMICS("Economics"),
    ENCYCLOPEDIAS("Encyclopedias"),
    ESOTERIC("Esoteric"),
    FOREIGN_LANGUAGES("Foreign languages"),
    HISTORY("History"),
    HOBBIES("Hobbies"),
    HUMANITIES("Humanities"),
    LITERATURE("Literature"),
    MEDICINE("Medicine"),
    PROGRAMMING("Programming"),
    REFERENCE_BOOKS("Reference books"),
    RIGHT("Right"),
    SCIENCES("Sciences"),
    TECHNIQUE("Technique");

    private String categoryName;
    private String description;

    BookCategoryEnum(String categoryName) {
        this.categoryName = categoryName;
        this.description = "";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
