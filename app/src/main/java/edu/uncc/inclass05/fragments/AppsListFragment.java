// InClass 05
// AppsListFragment.java
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.inclass05.R;
import edu.uncc.inclass05.databinding.FragmentAppsListBinding;
import edu.uncc.inclass05.models.DataServices;

public class AppsListFragment extends Fragment {

    FragmentAppsListBinding binding;

    private static final String ARG_PARAM_CATEGORY = "ARG_PARAM_CATEGORY";

    private String mCategory;
    private ArrayList<DataServices.App> apps;

    public static AppsListFragment newInstance(String category) {
        AppsListFragment fragment = new AppsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getString(ARG_PARAM_CATEGORY);
            apps = DataServices.getAppsByCategory(mCategory);
            requireActivity().setTitle(mCategory);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppsListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.listListListView.setAdapter(new AppAdapter(requireActivity(), R.layout.apps_list_app_row, apps));
        binding.listListListView.setOnItemClickListener((parent, v, position, id) -> {

        });
    }

    public static class AppAdapter extends ArrayAdapter<DataServices.App> {
        public AppAdapter(@NonNull Context context, int resource, @NonNull List<DataServices.App> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.apps_list_app_row, parent, false);
            }

            DataServices.App app = getItem(position);

            TextView appRowNameTextView = convertView.findViewById(R.id.appRowNameTextView);
            TextView appRowArtistTextView = convertView.findViewById(R.id.appRowArtistTextView);
            TextView appRowReleaseDateTextView = convertView.findViewById(R.id.appRowReleaseDateTextView);

            appRowNameTextView.setText(app.name);
            appRowArtistTextView.setText(app.artistName);
            appRowReleaseDateTextView.setText(app.releaseDate);

            return convertView;
        }
    }
}