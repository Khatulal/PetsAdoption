package sadna.java.petsadoption;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseObject;

import java.util.List;

import sadna.java.petsadoption.databinding.FragmentWatchPetsBinding;

public class WatchPetsFragment extends Fragment {
    public static final int MAX_LIST_SIZE = 50;

    private FragmentWatchPetsBinding binding;

    private RecyclerView recyclerView;
    private ImageView[] imagesList;
    private String[] petsTextList;
    private Button[] buttonsList;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,

            Bundle savedInstanceState
    ) {

        binding = FragmentWatchPetsBinding.inflate(inflater, container, false);
        recyclerView = binding.rvWatchPetsList;
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<ParseObject> petsList = DatabaseHandler.getAllPets();
        PetsAdapter pets_adapter = new PetsAdapter(this.getContext(),null,
                1,
                "name",
                1111,
                "2222",
                1,
                true,
                4,
                "description");
        recyclerView.setAdapter(pets_adapter);
        //recyclerView.setLayoutManager(new recyclerView(this));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}