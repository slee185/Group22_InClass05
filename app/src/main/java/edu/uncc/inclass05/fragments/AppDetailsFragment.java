// InClass 05
// AppDetailsFragment.java
// Ken Stanley & Stephanie Karp

package edu.uncc.inclass05.fragments;

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
import edu.uncc.inclass05.databinding.FragmentAppDetailsBinding;
import edu.uncc.inclass05.models.DataServices;

public class AppDetailsFragment extends Fragment {

    FragmentAppDetailsBinding binding;

    private static final String ARG_PARAM_APP = "ARG_PARAM_APP";

    private DataServices.App app;

    public static AppDetailsFragment newInstance(DataServices.App app) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_APP, app);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            app = (DataServices.App) getArguments().getSerializable(ARG_PARAM_APP);
            requireActivity().setTitle(R.string.app_name_app_details);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> genres = app.genres;

        ListView listViewAppDetailsGenres = binding.listViewAppDetailsGenres;
        listViewAppDetailsGenres.setAdapter(new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, genres));
    }
}