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
import jondi.ts.cocktailappproject.models.Cocktail;
import jondi.ts.cocktailappproject.details.CocktailDetailsAction;

public class CocktailsRecyclerViewAdapter extends RecyclerView.Adapter<CocktailsRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Cocktail> cocktails;
    private CocktailDetailsAction action;

    public CocktailsRecyclerViewAdapter(Context context, ArrayList<Cocktail> cocktails, CocktailDetailsAction action) {
        this.context = context;// can be deleted
        this.cocktails = cocktails;
        this.action = action;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);//instead parent.context
        View view = inflater.inflate(R.layout.cocktail_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Next object in the list
        Cocktail cocktail = cocktails.get(position);
        // Cocktail variables
        String cocktailId = String.valueOf(cocktail.getId());
        String imageURL = cocktail.getCocktailImage();
        String cocktailName = cocktail.getCocktailName();
        // Set the textView to the cocktails name
        holder.cocktailTitle.setText(cocktailName);
        // download the image to the imageView
        Picasso.get().load(imageURL).placeholder(R.drawable.ic_drink_gurly_drink).into(holder.cocktailImage);

        // Add a click listener to our holder view
        holder.cocktailImage.setOnClickListener(v -> {
            action.cocktailClicked(cocktailId);
        });
    }

    @Override
    public int getItemCount() {
        return cocktails.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView cocktailTitle;
        ImageView cocktailImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cocktailTitle = itemView.findViewById(R.id.foodTitle);
            cocktailImage = itemView.findViewById(R.id.foodImage);
        }
    }
}
