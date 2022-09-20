// In Class Assignment 05
// Group22_InClass05
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.inclass05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.uncc.inclass05.databinding.ActivityMainBinding;
import edu.uncc.inclass05.fragments.AppCategoriesFragment;
import edu.uncc.inclass05.fragments.AppDetailsFragment;
import edu.uncc.inclass05.fragments.AppsListFragment;
import edu.uncc.inclass05.models.DataServices;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.AppCategoriesListener, AppsListFragment.AppsListListener {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoriesFragment())
                .commit();
    }

    @Override
    public void sendSelectedCategory(String category) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppsListFragment.newInstance(category))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendSelectedApp(DataServices.App app) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppDetailsFragment.newInstance(app))
                .addToBackStack(null)
                .commit();
    }
}