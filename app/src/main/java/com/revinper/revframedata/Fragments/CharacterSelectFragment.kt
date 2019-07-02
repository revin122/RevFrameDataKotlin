package com.revinper.revframedata.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.revinper.revframedata.Model.FGCharacter

import com.revinper.revframedata.R
import com.revinper.revframedata.ViewModel.FGAllCharactersViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CharacterSelectFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CharacterSelectFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CharacterSelectFragment : Fragment() {

    private var listener: OnCharacterFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragmentView = inflater.inflate(R.layout.fragment_character_select, container, false)

        val model = ViewModelProviders.of(this).get(FGAllCharactersViewModel::class.java)
        model.getCharacters().observe(this, Observer<List<FGCharacter>>{ characters ->
            // update UI
            Log.i("REVFrameData", "Character count : ${characters.size}")

            if (characters.size > 0) {

            } else {
                //TODO ERROR HERE
            }
        })

        return fragmentView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCharacterFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }


    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnCharacterFragmentListener {
        fun onCharacterSelected()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CharacterSelectFragment.
         */

        @JvmStatic
        fun newInstance() =
                CharacterSelectFragment().apply {

                }
    }
}
