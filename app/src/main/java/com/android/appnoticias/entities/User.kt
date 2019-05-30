package com.android.appnoticias.entities

import com.google.gson.annotations.SerializedName

class User (

    @SerializedName("id")
    var id: String?,
    @SerializedName("nome")
    var nome: String,
    @SerializedName("email")
    var email: String

)
{

}
