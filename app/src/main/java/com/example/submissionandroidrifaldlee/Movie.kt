package com.example.submissionandroidrifaldlee

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Movie(
    val title: String,
    val rating: String,
    val year: String,
    val genre: String,
    val duration: String,
    val country: String,
    val synopsis: String,
    val poster: Int
) :Parcelable