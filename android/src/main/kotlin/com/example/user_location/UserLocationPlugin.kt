package com.example.user_location

import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.EventChannel.EventSink
import io.flutter.plugin.common.EventChannel.StreamHandler
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall


class UserLocationPlugin: FlutterPlugin, MethodChannel.MethodCallHandler {
  companion object {
      var listener: LocationListener? = null
      var locationManager: LocationManager? = null
  }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        val channel = MethodChannel(binding.binaryMessenger, "user_location")
        channel.setMethodCallHandler(this)

        val eventChannel = EventChannel(binding.binaryMessenger, "locationStatusStream")

        eventChannel.setStreamHandler(
            object: StreamHandler {
                override fun onListen(p0: Any?, p1: EventSink) {
                    listener = object : LocationListener {
                        override fun onLocationChanged(location: android.location.Location) {
                        }

                        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

                        }

                        override fun onProviderEnabled(provider: String) {
                            p1.success(true)
                        }

                        override fun onProviderDisabled(provider: String) {
                            p1.success(false)
                        }
                    }


                }
                override fun onCancel(p0: Any?) {
                    locationManager?.removeUpdates(listener ?: return)
                }
            }
        )
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        locationManager?.removeUpdates(listener ?: return)
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else {
            result.notImplemented()
        }
    }

}
