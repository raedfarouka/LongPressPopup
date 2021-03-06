package rm.com.longpresspopup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Riccardo on 11/11/16.
 */

public class DialogPopup extends AlertDialog {

    private static final String TAG = DialogPopup.class.getSimpleName();

    @LongPressPopup.AnimationType
    private int mAnimationType;

    DialogPopup(@NonNull Context context,
                @LongPressPopup.AnimationType int animationType) {
        super(context);

        mAnimationType = animationType;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            // Setup the dialog popup animation
            if (getWindow() != null) {

                int animations = 0;
                switch (mAnimationType) {
                    case LongPressPopup.ANIMATION_TYPE_NO_ANIMATION:

                        animations = 0;
                        break;

                    case LongPressPopup.ANIMATION_TYPE_FROM_LEFT:

                        animations = R.style.DialogAnimationsFromLeft;
                        break;

                    case LongPressPopup.ANIMATION_TYPE_FROM_RIGHT:

                        animations = R.style.DialogAnimationsFromRight;
                        break;

                    case LongPressPopup.ANIMATION_TYPE_FROM_BOTTOM:

                        animations = R.style.DialogAnimationsFromBottom;
                        break;
                    case LongPressPopup.ANIMATION_TYPE_FROM_TOP:

                        animations = R.style.DialogAnimationsFromTop;
                        break;

                    case LongPressPopup.ANIMATION_TYPE_FROM_CENTER:

                        animations = R.style.DialogAnimationsFromCenter;
                        break;
                }

                getWindow().getAttributes().width =
                        (int) (getDeviceMetrics(getContext()).widthPixels *0.95);

                ColorDrawable back = new ColorDrawable();
                getWindow().setBackgroundDrawable(back);

                getWindow().setWindowAnimations(animations);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DisplayMetrics getDeviceMetrics(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }

}
