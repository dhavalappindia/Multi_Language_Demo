package adapter;


import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import model.LanguageModel;
import com.app.multilanguagedemo.LanguagesActivity;
import com.app.multilanguagedemo.R;

import java.util.ArrayList;




public class LanguageDataAdapter extends RecyclerView.Adapter<LanguageDataAdapter.ViewHolder> {




    ArrayList<LanguageModel> filterCategoryData;
LanguagesActivity activity;
    int selectedPosition = 0;


    public LanguageDataAdapter(int selectedPosition, LanguagesActivity activity, ArrayList<LanguageModel> filterCategoryData) {
        this.selectedPosition = selectedPosition;
        this.filterCategoryData = filterCategoryData;
        this.activity = activity;



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_list, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        Log.d("tag", "position---" + i);
        if (i == selectedPosition) {
            Log.d("tag", "if select position---" + selectedPosition);

            viewHolder.tv_filter_category_name.setTypeface(null, Typeface.BOLD);
            viewHolder.iv_select.setVisibility(View.VISIBLE);
        } else {

            viewHolder.iv_select.setVisibility(View.INVISIBLE);
        }

        viewHolder.tv_filter_category_name.setText("" + filterCategoryData.get(i).getLanguage_name());

        viewHolder.lin_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("tag", "send select position---");
                selectedPosition = i;

                Log.d("tag", "if  set select position---" + selectedPosition);
                activity.fiterCategoryItemClick(i, filterCategoryData.get(i).getLanguage_code());
            }
        });


    }

    @Override
    public int getItemCount() {

        return filterCategoryData.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        LinearLayout lin_category;
        ImageView iv_select;
        private TextView tv_filter_category_name, tv_filter_category_size;

        public ViewHolder(final View view) {
            super(view);

            lin_category = view.findViewById(R.id.lin_category);
            tv_filter_category_name = view.findViewById(R.id.tv_filter_category_name);
            tv_filter_category_size = view.findViewById(R.id.tv_filter_category_size);
            iv_select = view.findViewById(R.id.iv_select);


        }
    }

}
