package kk.techbytecare.instafilters.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import kk.techbytecare.instafilters.Adapter.ColorAdapter;
import kk.techbytecare.instafilters.Interface.BrushFragmentListener;
import kk.techbytecare.instafilters.Interface.ColorAdapterListener;
import kk.techbytecare.instafilters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrushFragment extends BottomSheetDialogFragment implements ColorAdapterListener {

    SeekBar seekBar_brush_size,seekBar_opacity;
    RecyclerView recycler_color;
    ToggleButton btn_brush_state;
    ColorAdapter adapter;

    BrushFragmentListener listener;

    public void setListener(BrushFragmentListener listener) {
        this.listener = listener;
    }

    static BrushFragment instance;

    public static BrushFragment getInstance() {
        if (instance == null)   {
            instance = new BrushFragment();
        }
        return instance;
    }

    public BrushFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_brush, container, false);

        seekBar_brush_size = itemView.findViewById(R.id.brush_size_bar);
        seekBar_opacity = itemView.findViewById(R.id.brush_opacity_bar);

        btn_brush_state = itemView.findViewById(R.id.btn_brush_state);

        recycler_color = itemView.findViewById(R.id.recycler_color);

        recycler_color.setHasFixedSize(true);
        recycler_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        adapter = new ColorAdapter(getContext(),this);
        recycler_color.setAdapter(adapter);

        seekBar_brush_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                listener.onBrushSizeChanged(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_opacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                listener.onBrushOpacityChanged(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_brush_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.onBrushStateChanged(isChecked);
            }
        });

        return itemView;
    }

    @Override
    public void onColorSelected(int color) {
        listener.onBrushColorChanged(color);
    }
}
