package com.test.models

import java.util.*

data class Delivery(
    val deliveryType: DeliveryType,
    val recipientName: String?,
    val senderName: String?,
    val time: Date,
    val pickupStatus: Int?,
    val deliveryStatus: Int?
)