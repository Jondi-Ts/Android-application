package jondi.ts.cocktailappproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.R;
import jondi.ts.cocktailappproject.details.CategoryListener;
import jondi.ts.cocktailappproject.models.FoodCategory;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FoodCategory> categories;
    private CategoryListener categoryListener;




    public FoodCategoryAdapter(Context context, ArrayList<FoodCategory> categories,CategoryListener categoryListener) {
        this.context = context;
        this.categories = categories;
        this.categoryListener = categoryListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_item, parent, false);
        return new FoodCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodCategory foodCategory = categories.get(position);
        String categoryName = foodCategory.getCategoryName();
        String imageUrl = foodCategory.getCategoryImage();
        holder.categoryName.setText(categoryName);
        Picasso.get().load(imageUrl).into(holder.categoryIv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryListener.didSelectCategory(foodCategory.getCategoryName());
            }
        });
    }


    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryIv = itemView.findViewById(R.id.categoryIv);
        }
    }

}
