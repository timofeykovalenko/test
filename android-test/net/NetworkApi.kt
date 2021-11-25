package com.test.net

import com.test.models.Delivery

interface NetworkApi {
    // some async function
    fun getDeliveries(): Delivery
}