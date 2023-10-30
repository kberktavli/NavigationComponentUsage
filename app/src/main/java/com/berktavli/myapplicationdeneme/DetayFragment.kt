package com.berktavli.myapplicationdeneme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.berktavli.myapplicationdeneme.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar

class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater,container,false)
        val bundle:DetayFragmentArgs by navArgs()

        val gelenAd = bundle.ad
        val gelenYas = bundle.yas
        val gelenBoy = bundle.boy
        val gelenBekar = bundle.bekar
        val urunId =  bundle.urun.id
        val urunAd = bundle.urun.ad

        binding.textView2.text = "Ad : $gelenAd\nYas : $gelenYas\nBoy : $gelenBoy\nMedeni Hali : $gelenBekar\nUrun İd : $urunId\nUrun Adı : $urunAd"

        val backPress = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Snackbar.make(binding.textView2,"Geri dönmek istiyor musunuz ?", Snackbar.LENGTH_LONG)
                    .setAction("EVET"){
                        isEnabled = false
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                    }
                    .show()

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPress)

        return binding.root
    }

}
