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
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentSignupBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.DefaultResponse
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.Response
import retrofit2.Call
import retrofit2.Callback
import java.io.StringReader


class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false)

        binding.signupButton.setOnClickListener{
            val name = binding.fullname.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            //json data
            val signupDataJson =
                "{\"name\":\"$name\",\"email\":\"$email\",\"password\":\"$password\"}"

            //validation
            if (name.isEmpty()){
                binding.fullname.error = "Full Name Required"
                binding.fullname.requestFocus()
            }
            if (email.isEmpty()){
                binding.email.error = "Email Required"
                binding.email.requestFocus()
            }
            if (password.isEmpty()){
                binding.password.error = "Password Required"
                binding.password.requestFocus()
            }
            try {
                val reader = JsonReader(StringReader(signupDataJson))
                reader.isLenient = true
                reader.beginObject()
                reader.close()
                RetrofitClient.instance.createUser(name, email, password).enqueue(object : Callback<DefaultResponse> {
                    override fun onResponse(call: Call<DefaultResponse>, response: retrofit2.Response<DefaultResponse>) {
                        // Handle response
                        if (response.isSuccessful && response.body() != null) {
                            Toast.makeText(requireContext(), response.body()!!.message, Toast.LENGTH_LONG).show()
                            startActivity(Intent(requireActivity(), LoginFragment::class.java))
                        }
                        else {
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

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        // Handle failure
                        Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                    }
                })

            } catch (e: Exception) {
                e.printStackTrace()
            }


        }
        return binding.root





    }


}