package com.berktavli.myapplicationdeneme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.berktavli.myapplicationdeneme.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container,false)
        binding.detayButton.setOnClickListener {
            val urun = Urunler(100,"TV")
            val gecis = AnasayfaFragmentDirections.actionDetay(urun = urun,ad = "Ahmet", yas = 27,boy = 1.78f,true)
            Navigation.findNavController(it).navigate(gecis)
        }

        return binding.root
    }
}