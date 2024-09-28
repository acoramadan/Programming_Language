package com.muflidevs.programmingL.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProgrammingData(
    val judul : String,
    val description : String,
    val photo : Int
) : Parcelable
