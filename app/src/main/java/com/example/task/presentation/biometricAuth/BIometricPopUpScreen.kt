package com.example.task.presentation.biometricAuth

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import androidx.navigation.NavHostController
import com.example.task.navigation.NavigationScreen

/*
@Composable
fun BiometricPopUpScreen( navController: NavHostController){

  //  val activity = context.getActivity()

   */
/* Biometric.authenticate(
        activity = activity,
        title = "Biometric Authentication",
        subtitle = "Authenticate to proceed",
        description = "Authentication is must",
        negativeText = "Cancel",
        onSuccess = {

                Toast.makeText(
                    context,
                    "Authenticated successfully",
                    Toast.LENGTH_SHORT
                )
                    .show()
            navController.navigate(NavigationScreen.DashBoard.route)


        },
        onError = {errorCode,errorString->

                Toast.makeText(
                    context,
                    "Authentication error: $errorCode, $errorString",
                    Toast.LENGTH_SHORT
                )
                    .show()

        },
        onFailed = {

                Toast.makeText(
                    context,
                    "Authentication failed",
                    Toast.LENGTH_SHORT
                )
                    .show()

        }
    )*//*


}
*/

@Composable
fun BiometricPopUpScreen(navController: NavHostController) {


    val context = LocalContext.current
    val activity = context.getActivity()
    println("Activity--$activity")
    if (activity != null) {
        val isEnabled = isAvailable(context)
        if (isEnabled) {
            //TO Activate Prompt
            Biometric.authenticate(
                activity = activity,
                title = "Biometric Authentication",
                subtitle = "Authenticate to proceed",
                description = "Authentication is must",
                negativeText = "Cancel",
                onSuccess = {
                    Log.e("Success", "BiometricPopUpScreen: ")

                    Toast.makeText(
                        context,
                        "Authenticated successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                    navController.navigate(NavigationScreen.DashBoard.route)
                            },

                onError = { errorCode, errorString ->

                    Toast.makeText(
                        context,
                        "Authentication error: $errorCode, $errorString",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                          },

                onFailed = {

                    Toast.makeText(
                        context,
                        "Authentication failed",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            )
        }
    }
}

fun isAvailable(context: Context): Boolean {
    val fingerprintManager = FingerprintManagerCompat.from(context)
    return fingerprintManager.isHardwareDetected && fingerprintManager.hasEnrolledFingerprints()
}
