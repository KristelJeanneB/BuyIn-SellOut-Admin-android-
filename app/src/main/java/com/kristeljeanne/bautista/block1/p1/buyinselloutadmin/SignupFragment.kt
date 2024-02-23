package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.os.Bundle
import android.util.JsonReader
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
            val name = binding.fullname.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

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
                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                        // Handle response
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        // Handle failure
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

                }
            }

        }
        return binding.root





    }


}