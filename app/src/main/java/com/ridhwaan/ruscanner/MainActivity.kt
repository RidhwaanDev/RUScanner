package com.ridhwaan.ruscanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ridhwaan.ruscanner.RUScanner.MaterialBarcodeScanner
import com.ridhwaan.ruscanner.RUScanner.MaterialBarcodeScannerActivity
import com.ridhwaan.ruscanner.RUScanner.MaterialBarcodeScannerBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val qrCodeScanning:MaterialBarcodeScanner = MaterialBarcodeScannerBuilder()
                .withActivity(this)
                .withEnableAutoFocus(true)
                .withBackfacingCamera()
                .build()
        qrCodeScanning.startScan()
    }
}
