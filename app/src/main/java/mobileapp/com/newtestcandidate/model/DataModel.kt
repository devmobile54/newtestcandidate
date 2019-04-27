package mobileapp.com.newtestcandidate.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
        @SerializedName("docType")
        val docType: String = ""
): Parcelable