package com.mcoc.fsent.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mcoc.fsent.R
import com.mcoc.fsent.databinding.ActivityBankAddEditBinding

class BankAddEditActivity : AppCompatActivity() {

    var binding: ActivityBankAddEditBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityBankAddEditBinding.inflate(layoutInflater())
        binding = ActivityBankAddEditBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        setContentView(R.layout.activity_bank_add_edit)

//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        val myFragment = BankAddEditFragment()
//        fragmentTransaction.add(R.id.fragment_container, myFragment)
//        fragmentTransaction.commit()


        //show back button
        supportActionBar?.setTitle(resources.getString(R.string.activity_title_bank_add))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // handle back button click here
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}