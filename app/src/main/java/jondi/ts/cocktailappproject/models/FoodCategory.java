package jondi.ts.cocktailappproject.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FoodCategory implements Serializable {

    @SerializedName("idCategory")
    private int idCategory;
    @SerializedName("strCategory")
    private String categoryName;
    @SerializedName("strCategoryThumb")
    private String categoryImage;
    @SerializedName("strCategoryDescription")
    private String categoryDescription;


    public FoodCategory() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }


    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", caregory='" + categoryName + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
