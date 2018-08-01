package com.adnroid.devcuba.messengerproject

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RecyclerActivity : AppCompatActivity() , RecyclerFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, RecyclerFragment.newInstance())
                .commit()
    }
}
