package kk.techbytecare.instafilters.Fragments;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kk.techbytecare.instafilters.Adapter.FrameAdapter;
import kk.techbytecare.instafilters.Interface.AddFrameListener;
import kk.techbytecare.instafilters.Interface.FrameAdapterListener;
import kk.techbytecare.instafilters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrameFragment extends BottomSheetDialogFragment implements FrameAdapterListener {

    RecyclerView recycler_frame;
    Button btn_add_frame;

    int frame_selected = -1;

    AddFrameListener listener;

    public void setListener(AddFrameListener listener) {
        this.listener = listener;
    }

    static FrameFragment instance;

    public static FrameFragment getInstance() {
        if (instance == null)   {
            instance = new FrameFragment();
        }
        return instance;
    }

    public FrameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frame, container, false);

        recycler_frame = view.findViewById(R.id.recycler_frames);
        btn_add_frame = view.findViewById(R.id.btn_add_frame);

        recycler_frame.setHasFixedSize(true);
        recycler_frame.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycler_frame.setAdapter(new FrameAdapter(getContext(),this));

        btn_add_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFrameAdd(frame_selected);
            }
        });

        return view;
    }

    @Override
    public void onFrameSelected(int frame) {
        frame_selected = frame;
    }
}
