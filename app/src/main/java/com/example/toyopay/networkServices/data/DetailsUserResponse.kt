package com.example.toyopay.networkServices.data

import com.google.gson.annotations.SerializedName

data class DetailsUserResponse(
    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("data"    ) var data    : DetailsData?   = DetailsData(),
    @SerializedName("message" ) var message : String? = null

)
data class DetailsData (

    @SerializedName("id"                               ) var id                               : Int?              = null,
    @SerializedName("firstName"                        ) var firstName                        : String?           = null,
    @SerializedName("lastName"                         ) var lastName                         : String?           = null,
    @SerializedName("email"                            ) var email                            : String?           = null,
    @SerializedName("mobilePhone"                      ) var mobilePhone                      : String?           = null,
    @SerializedName("roleName"                         ) var roleName                         : String?           = null,
    @SerializedName("userTypeName"                     ) var userTypeName                     : String?           = null,
    @SerializedName("username"                         ) var username                         : String?           = null,
    @SerializedName("permissions"                      ) var permissions                      : ArrayList<String> = arrayListOf(),
    @SerializedName("isActive"                         ) var isActive                         : Boolean?          = null,
    @SerializedName("branch"                           ) var branch                           : DetailsBranch?    = DetailsBranch(),
    @SerializedName("isAdmin"                          ) var isAdmin                          : Boolean?          = null,
    @SerializedName("isRegional"                       ) var isRegional                       : Boolean?          = null,
    @SerializedName("isTwoFactorAuthenticationEnabled" ) var isTwoFactorAuthenticationEnabled : Boolean?          = null,
    @SerializedName("otpTypeId"                        ) var otpTypeId                        : String?           = null,
    @SerializedName("googleTwoFactorAuthentication"    ) var googleTwoFactorAuthentication    : String?           = null,
    @SerializedName("isSenderAddInfoAvailable"         ) var isSenderAddInfoAvailable         : Boolean?          = null,
    @SerializedName("isSenderDocInfoAvailable"         ) var isSenderDocInfoAvailable         : Boolean?          = null,
    @SerializedName("nationalityId"                    ) var nationalityId                    : Int?              = null,
    @SerializedName("residentialStatusId"              ) var residentialStatusId              : Int?              = null

)
data class DetailsBranch (

    @SerializedName("id"                 ) var id                 : Int?     = null,
    @SerializedName("code"               ) var code               : String?  = null,
    @SerializedName("typeId"             ) var typeId             : Int?     = null,
    @SerializedName("title"              ) var title              : String?  = null,
    @SerializedName("cityId"             ) var cityId             : Int?     = null,
    @SerializedName("countryId"          ) var countryId          : Int?     = null,
    @SerializedName("phone"              ) var phone              : String?  = null,
    @SerializedName("branchIp"           ) var branchIp           : String?  = null,
    @SerializedName("limit"              ) var limit              : Int?     = null,
    @SerializedName("parentId"           ) var parentId           : Int?     = null,
    @SerializedName("isVisible"          ) var isVisible          : Boolean? = null,
    @SerializedName("sendCashCommission" ) var sendCashCommission : Int?     = null,
    @SerializedName("payCashCommission"  ) var payCashCommission  : Int?     = null,
    @SerializedName("commissionPolicyId" ) var commissionPolicyId : Int?     = null,
    @SerializedName("baseCurrencyId"     ) var baseCurrencyId     : Int?     = null,
    @SerializedName("branchStatus"       ) var branchStatus       : Boolean? = null,
    @SerializedName("cpoAccountId"       ) var cpoAccountId       : Int?     = null,
    @SerializedName("createdBy"          ) var createdBy          : Int?     = null,
    @SerializedName("createdDate"        ) var createdDate        : String?  = null,
    @SerializedName("lastModifiedDate"   ) var lastModifiedDate   : String?  = null

)