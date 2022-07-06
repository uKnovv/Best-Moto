package com.uknow.bestmoto.util

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageAsync(resId: Int) {
    Glide.with(this.context)
        // Add placeholder
        .load(resId)
        .into(this)
}

fun ImageView.setImageAsync(bitmap: Bitmap) {
    Glide.with(this.context)
        // Add placeholder
        .load(bitmap)
        .into(this)
}