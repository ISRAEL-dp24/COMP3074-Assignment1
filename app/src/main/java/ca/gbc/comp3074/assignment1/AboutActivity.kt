package ca.gbc.comp3074.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Enables the back button
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handles back button press to return to MainActivity
        return true
    }
}