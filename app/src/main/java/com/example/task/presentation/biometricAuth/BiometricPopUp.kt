package com.example.task.presentation.biometricAuth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.example.task.navigation.Navigation
import com.example.task.navigation.NavigationScreen

class BiometricPopUp : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current
            val activity = context.getActivity()
            Biometric.authenticate(
                activity =activity!!,
                title = "Biometric Authentication",
                subtitle = "Authenticate to proceed",
                description = "Authentication is must",
                negativeText = "Cancel",
                onSuccess = {

                    Toast.makeText(
                        this@BiometricPopUp,
                        "Authenticated successfully",
                        Toast.LENGTH_SHORT
                    )
                        .show()



                },
                onError = {errorCode,errorString->

                    Toast.makeText(
                        this@BiometricPopUp,
                        "Authentication error: $errorCode, $errorString",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                },
                onFailed = {

                    Toast.makeText(
                        this@BiometricPopUp,
                        "Authentication failed",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                }
            )
        }
    }
}