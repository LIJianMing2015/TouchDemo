package chenxianru.qianfeng.com.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by aaa on 15-4-21.
 */
public class Layout_2 extends FrameLayout {
    private static final String TAG = "-------->Layout_2";

    public Layout_2(Context context) {
        super(context);
    }

    public Layout_2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_2(Context context, AttributeSet attrs, int defStyleAttr) {
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
     * @return 是否处理了触摸事件，如果返回值是true，那么接下来的触摸事件都由一个控件来处理
     * 返回值只有在ACTION_DOWN 时候有效，MOVE，UP时候无效，没人去理会他
     * 。
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        boolean flag = false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                flag = true;
                break;
            case MotionEvent.ACTION_MOVE:
                flag = false;
                break;
            case MotionEvent.ACTION_UP:
                flag = false;
                break;
        }

        return flag;

        //return super.onTouchEvent(event);
    }
}
