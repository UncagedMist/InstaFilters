package kk.techbytecare.instafilters.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import kk.techbytecare.instafilters.Interface.EditImageFragmentListener;
import kk.techbytecare.instafilters.R;

public class EditFragment extends BottomSheetDialogFragment implements SeekBar.OnSeekBarChangeListener {

    private EditImageFragmentListener listener;
    SeekBar seekBar_brightness,seekBar_saturation,seekBar_contrast;

    static EditFragment instance;

    public static EditFragment getInstance() {
        if (instance == null)   {
            instance = new EditFragment();
        }
        return instance;
    }

    public void setListener(EditImageFragmentListener listener) {
        this.listener = listener;
    }

    public EditFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_edit, container, false);

        seekBar_brightness = itemView.findViewById(R.id.brightness_bar);
        seekBar_saturation = itemView.findViewById(R.id.saturation_bar);
        seekBar_contrast = itemView.findViewById(R.id.contrast_bar);

        seekBar_brightness.setMax(200);
        seekBar_brightness.setProgress(100);

        seekBar_saturation.setMax(30);
        seekBar_saturation.setProgress(10);

        seekBar_contrast.setMax(20);
        seekBar_contrast.setProgress(0);

        seekBar_saturation.setOnSeekBarChangeListener(this);
        seekBar_contrast.setOnSeekBarChangeListener(this);
        seekBar_brightness.setOnSeekBarChangeListener(this);

        return itemView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (listener != null)   {

            if (seekBar.getId() == R.id.brightness_bar) {
                listener.onBrightnessChanged(progress - 100);
            }
            else if (seekBar.getId() == R.id.contrast_bar)  {
                progress += 10;
                float value = .10f * progress;
                listener.onContrastChanged(value);
            }
            else if (seekBar.getId() == R.id.saturation_bar)  {
                float value = .10f * progress;
                listener.onSaturationChanged(value);
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (listener != null)   {
            listener.onEditStarted();
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (listener != null)   {
            listener.onEditCompleted();
        }
    }

    public void resetControls() {
        seekBar_brightness.setProgress(100);
        seekBar_contrast.setProgress(0);
        seekBar_saturation.setProgress(10);
    }
}
