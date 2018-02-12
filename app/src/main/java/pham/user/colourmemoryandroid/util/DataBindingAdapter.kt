package pham.user.colourmemoryandroid.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Pham on 12/2/2018.
 */
@BindingAdapter("imageRes")
fun setImageResource(view: ImageView, resId: Int) {
    Glide.with(view.context).load(resId).into(view)
}