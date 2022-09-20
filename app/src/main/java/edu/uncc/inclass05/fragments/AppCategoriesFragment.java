// InClass 05
// AppCategoriesFragment.java
// Ken Stanley & Stephanie Karp

package edu.uncc.inclass05.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.uncc.inclass05.R;
import edu.uncc.inclass05.databinding.FragmentAppCategoriesBinding;
import edu.uncc.inclass05.models.DataServices;

public class AppCategoriesFragment extends Fragment {
    FragmentAppCategoriesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().setTitle(R.string.app_name_categories);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppCategoriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> categories = DataServices.getAppCategories();

        ListView categoriesCategoriesListView = binding.categoriesCategoriesListView;
        categoriesCategoriesListView.setAdapter(new ArrayAdapter<>(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                categories
        ));

        categoriesCategoriesListView.setOnItemClickListener((parent, v, position, id) -> {
            mListener.sendSelectedCategory(categories.get(position));
        });
    }

    AppCategoriesListener mListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (AppCategoriesListener) context;
    }

    public interface AppCategoriesListener {
        void sendSelectedCategory(String category);
    }
}