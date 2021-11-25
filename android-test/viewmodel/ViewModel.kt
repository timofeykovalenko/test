package com.test.viewmodel

import com.test.db.Database
import com.test.models.Delivery
import com.test.models.DeliveryType
import com.test.net.NetworkApi
import java.util.*

class ViewModel(val networkApi: NetworkApi, val database: Database) {

    // It is used by UI to show on the screen, imagine it is LiveData
    var liveDataName: String? = null
    var liveDataTime: Date? = null

    init {

        val dbDelivery = database.getDeliveries()

        if (dbDelivery == null) {
            val netDelivery = networkApi.getDeliveries()
            database.saveDeliveries(netDelivery)
            processResults(netDelivery)
        } else {
            processResults(dbDelivery)
        }
    }

    fun processResults(delivery: Delivery) {

        if (delivery.deliveryType == DeliveryType.DELIVERY) {
            liveDataName = delivery.recipientName
        } else {
            liveDataName = delivery.senderName
        }

        liveDataTime = delivery.time
    }

}