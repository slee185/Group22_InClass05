// In Class Assignment 05
// Group22_InClass05
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.inclass05.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.uncc.inclass05.R;
import edu.uncc.inclass05.databinding.FragmentAppsListBinding;
import edu.uncc.inclass05.models.DataServices;

public class AppsListFragment extends Fragment {

    FragmentAppsListBinding binding;

    ListView listViewAppsList;

    ArrayAdapter<String> adapter;

    public AppsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppsListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listViewAppsList = view.findViewById(R.id.listViewAppCategories);

        adapter = new ArrayAdapter<>(requireActivity().getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, DataServices.getAppCategories());
        listViewAppsList.setAdapter(adapter);


        listViewAppsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}