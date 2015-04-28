package chenxianru.qianfeng.com.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by aaa on 15-4-21.
 */
public class Layout_3 extends FrameLayout {
    private static final String TAG = "-------->Layout_3";

    public Layout_3(Context context) {
        super(context);
    }

    public Layout_3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 触摸事件分发，
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 打断触摸事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent");

        return super.onInterceptTouchEvent(ev);

    }

    /**
     * 触摸事件的处理
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");

        return super.onTouchEvent(event);
    }
}
