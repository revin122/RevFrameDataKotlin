package com.revinper.revframedata.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.revinper.revframedata.Model.FGCharacter
import org.json.JSONObject

class FGAllCharactersViewModel : ViewModel() {

    private val TAG : String = "FGAllCharacters"

    private val characters : MutableLiveData<List<FGCharacter>> by lazy {
        MutableLiveData<List<FGCharacter>>().also {
            loadCharacters()
        }
    }

    fun getCharacters() : LiveData<List<FGCharacter>> {
        return characters
    }

    private fun loadCharacters() {
        //connect to firebase db

        val database = FirebaseFirestore.getInstance()
        database.collection("characters")
            .get()
            .addOnSuccessListener { result ->
                val mutableCharacterList = mutableListOf<FGCharacter>()
                for (document in result) {
                    val characterJSON = JSONObject(document.data)
                    val character = FGCharacter(if (characterJSON.has("Name")) characterJSON.getString("Name") else "Temp",
                        if (characterJSON.has("image")) characterJSON.getString("image") else "",
                        if (characterJSON.has("movelist")) characterJSON.getString("movelist") else "")

                    mutableCharacterList.add(character)
                }

                //sort by name

                characters.value = mutableCharacterList
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Error getting documents.", exception)
                //There should be no characters, because of that we know there is an error
                characters.value = listOf()
            }
    }

}