package com.uknow.bestmoto.model

data class Item(
    val title: String?,
    val description: String?,
    val price: Int?,
    val type: String?,
    val img_src: String?,
    val color_variants: String?,
    val params: Map<String, String>?,
    val id: Int?
)
