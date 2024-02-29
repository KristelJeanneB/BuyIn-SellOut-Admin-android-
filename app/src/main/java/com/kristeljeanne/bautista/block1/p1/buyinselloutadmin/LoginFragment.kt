package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.content.Intent
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.Api.RetrofitClient
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentLoginBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentSignupBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener {
            val email = binding.logemail.text.toString()
            val password = binding.logpassword.text.toString()

            val signinDataJson =
                "{\"email\":\"$email\",\"password\":\"$password\"}"

            if (email.isEmpty()) {
                binding.logemail.error = "Email required"
                binding.logemail.requestFocus()
            }

            if (password.toString().isEmpty()) {
                binding.logpassword.error = "Password required"
                binding.logpassword.requestFocus()
            }
            try {
                val reader = JsonReader(StringReader(signinDataJson))
                reader.isLenient = true
                reader.beginObject()
                reader.close()
                RetrofitClient.instance.login(email, password).enqueue(object :
                    Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: Response<DefaultResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            // Handle successful response
                            Toast.makeText(
                                requireContext(),
                                response.body()!!.message,
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(
                                Intent(requireActivity(), DashboardFragment::class.java)
                            )
                        } else {
                            // Handle unsuccessful response
                            val errorMessage: String = try {
                                response.errorBody()?.string()
                                    ?: "Failed to get a valid response. Response code: ${response.code()}"
                            } catch (e: Exception) {
                                "Failed to get a valid response. Response code: ${response.code()}"
                            }
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG)
                                .show()
                            Log.e("API_RESPONSE", errorMessage)
                        }
                    }
                })
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error parsing JSON", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }


        }


    return binding.root
    }
}