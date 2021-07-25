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
import jondi.ts.cocktailappproject.details.CocktailDetailsAction;
import jondi.ts.cocktailappproject.details.FoodDetailsAction;
import jondi.ts.cocktailappproject.models.Food;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Food> foods;
    private FoodDetailsAction action;

    public FoodRecyclerViewAdapter(Context context, ArrayList<Food> foods, FoodDetailsAction action) {
        this.context = context;
        this.foods = foods;
        this.action = action;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
//inflate the view
        View v = inflater.inflate(R.layout.food_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foods.get(position);
        String foodId = String.valueOf(food.getId());
        String imageURL = food.getFoodImage();
        String foodName = food.getFoodName();
        holder.foodTitle.setText(foodName);
        Picasso.get().load(imageURL).placeholder(R.drawable.ic_food).into(holder.foodImage);
        holder.foodImage.setOnClickListener(v -> {
            action.foodClicked(foodId);
        });
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodTitle;
        ImageView foodImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodTitle = itemView.findViewById(R.id.foodTitle);
            foodImage = itemView.findViewById(R.id.foodImage);
        }
    }
}
