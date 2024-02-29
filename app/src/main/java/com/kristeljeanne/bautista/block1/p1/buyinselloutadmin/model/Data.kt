package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model

data class Data(
    val barcode: String,
    val brand_id: Int,
    val category_id: Int,
    val compare_price: String,
    val created_at: String,
    val description: String,
    val id: Int,
    val is_featured: String,
    val price: String,
    val product_images: List<ProductImage>,
    val qty: Int,
    val related_products: String,
    val shipping_return: Any,
    val short_description: Any,
    val sku: String,
    val slug: String,
    val status: Int,
    val sub_category_id: Int,
    val title: String,
    val track_qty: String,
    val updated_at: String
)