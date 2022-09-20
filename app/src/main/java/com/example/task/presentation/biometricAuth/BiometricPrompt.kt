/*
package com.example.task.presentation.biometricAuth

import android.content.Context
import android.content.ContextWrapper
import android.os.CancellationSignal
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.example.task.navigation.NavigationScreen

@OptIn(ExperimentalComposeUiApi::class)
fun bioMetricsPrompts(fr: AppCompatActivity, navController: NavController) {
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Verifica tu identidad")
        .setSubtitle("Usa tu huella digital para verificar tu identidad")
        .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
        .setNegativeButtonText("Cancelar")
        .build()

    val cancellationSignal = CancellationSignal()
    cancellationSignal.setOnCancelListener {
        //handle cancellation
    }
    val biometricPrompt = BiometricPrompt(
        fr,
        object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    */
/*navController.popBackStack()
                    navController.navigate(Screen.Dashboard.route)*//*

                }else if(errorCode == BiometricPrompt.ERROR_USER_CANCELED){
                }
                else if(errorCode == BiometricPrompt.ERROR_NO_BIOMETRICS){
                }
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                navController.navigate(NavigationScreen.DashBoard.route)
            }
        }
    )
    biometricPrompt.authenticate(promptInfo)
}

fun Context.getActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
*/
