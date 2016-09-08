package id.zainalfahrudin.orbit.ui;

/**
 * Wrote by :
 * Zainal Fahrudin
 * fnzainal@gmail.com
 * on 08/09/16 14:10.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zainal on 07/10/15.
 */
public class Courgette extends TextView{


    public Courgette(Context context) {
        super(context);
        init();
    }
    public Courgette(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Courgette(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Courgette(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Courgette-Regular.ttf");
        setTypeface(tf);

    }
}
