package com.android.jspark.find_book

/*
    title : 제목
    link : url 링크
    image : 책 이미지
    author : 저자
    price : 가격
    discount : 할인 가격
    publisher : 출판사
    description : 책 설명
 */

data class Item(
    val title: String,
    val link: String,
    val image: String,
    val author: String,
    val price: String,
    val discount: String,
    val publisher: String,
    val pubdate: String,
    val isbn: String,
    val description: String
)