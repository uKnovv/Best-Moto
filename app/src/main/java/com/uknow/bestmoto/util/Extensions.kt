package com.uknow.bestmoto.util

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

internal fun ImageView.setImageAsync(resId: Int) {
    Glide.with(this.context)
        // Add placeholder
        .load(resId)
        .into(this)
}

internal fun ImageView.setImageAsync(bitmap: Bitmap) {
    Glide.with(this.context)
        // Add placeholder
        .load(bitmap)
        .into(this)
}

internal fun NestedScrollView.setupAutoExtendFab(extFab: ExtendedFloatingActionButton) {
    this.setOnScrollChangeListener(
        NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY > oldScrollY + 12 && extFab.isExtended) {
                extFab.shrink()
            }
            if (scrollY < oldScrollY - 12 && !extFab.isExtended) {
                extFab.extend()
            }
            if (scrollY == 0) {
                extFab.extend()
            }
        }
    )
}

internal fun Fragment.getClassName(): String {
    return this::class.java.simpleName
}