package kk.techbytecare.instafilters.Interface;

public interface BrushFragmentListener {

    void onBrushSizeChanged(float size);
    void onBrushOpacityChanged(int opacity);
    void onBrushColorChanged(int color);
    void onBrushStateChanged(boolean isEraser);
}
