package self.edu.fragmentv1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by isolanki on 13-Feb-17.
 */

public class PlaybackFragment extends Fragment {
    private View view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playback, container, false);
        return view;
    }
}
