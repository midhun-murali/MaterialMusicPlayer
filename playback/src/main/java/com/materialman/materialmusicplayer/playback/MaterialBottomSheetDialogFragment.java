package com.materialman.materialmusicplayer.playback;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;

/**
 * This class is used for..
 *
 * @author Midhun.
 */
public class MaterialBottomSheetDialogFragment extends BottomSheetDialogFragment {

   /* @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogTheme);
        return null;
    }*/

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(getActivity(), R.style.BottomSheetDialogTheme);
    }

}
