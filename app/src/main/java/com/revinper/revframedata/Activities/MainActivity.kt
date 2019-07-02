package com.revinper.revframedata.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.revinper.revframedata.Fragments.CharacterSelectFragment
import com.revinper.revframedata.R

class MainActivity : AppCompatActivity(), CharacterSelectFragment.OnCharacterFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set the characters fragment in the soon to be changed framelayout

        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, CharacterSelectFragment.newInstance(), "CharacterSelect")
            .commit()
    }

    override fun onCharacterSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
