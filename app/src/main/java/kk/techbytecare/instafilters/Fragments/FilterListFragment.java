package kk.techbytecare.instafilters.Fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zomato.photofilters.FilterPack;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.utils.ThumbnailItem;
import com.zomato.photofilters.utils.ThumbnailsManager;

import java.util.ArrayList;
import java.util.List;

import kk.techbytecare.instafilters.Adapter.ThumbnailAdapter;
import kk.techbytecare.instafilters.Interface.FilterListFragmentListener;
import kk.techbytecare.instafilters.MainActivity;
import kk.techbytecare.instafilters.R;
import kk.techbytecare.instafilters.Utils.BitmapUtils;
import kk.techbytecare.instafilters.Utils.SpacesItemDecoration;

public class FilterListFragment extends Fragment implements FilterListFragmentListener {

    RecyclerView recyclerView;
    ThumbnailAdapter adapter;

    List<ThumbnailItem> thumbnailItems;

    FilterListFragmentListener listener;

    public void setListener(FilterListFragmentListener listener) {
        this.listener = listener;
    }

    public FilterListFragment() {
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
        View itemView = inflater.inflate(R.layout.fragment_filter_list, container, false);

        thumbnailItems = new ArrayList<>();
        adapter = new ThumbnailAdapter(thumbnailItems,this,getActivity());

        recyclerView = itemView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,getResources().getDisplayMetrics());
        recyclerView.addItemDecoration(new SpacesItemDecoration(space));
        recyclerView.setAdapter(adapter);

        displayThumbnail(null);

        return itemView;
    }

    @Override
    public void onFilerSelected(Filter filter) {
        if (listener != null)   {
            listener.onFilerSelected(filter);
        }
    }

    public void displayThumbnail(final Bitmap bitmap) {
        final Runnable r = new Runnable() {
            @Override
            public void run()   {
                Bitmap thumbImg;

                if (bitmap == null) {
                    thumbImg = BitmapUtils.getBitmapFromAssets(getActivity(), MainActivity.PIC_NAME,100,100);
                }
                else    {
                    thumbImg = Bitmap.createScaledBitmap(bitmap,100,100,false);
                }

                if (thumbImg == null)   {
                    return;
                }
                ThumbnailsManager.clearThumbs();
                thumbnailItems.clear();

                ThumbnailItem thumbnailItem = new ThumbnailItem();
                thumbnailItem.image = thumbImg;
                thumbnailItem.filterName = "Normal";
                ThumbnailsManager.addThumb(thumbnailItem);

                List<Filter> filters = FilterPack.getFilterPack(getActivity());

                for (Filter filter : filters)   {
                    ThumbnailItem tI = new ThumbnailItem();
                    tI.image = thumbImg;
                    tI.filter = filter;
                    tI.filterName = filter.getName();
                    ThumbnailsManager.addThumb(tI);
                }

                thumbnailItems.addAll(ThumbnailsManager.processThumbs(getActivity()));

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        };
        new Thread(r).start();
    }
}
