package ca.gbc.comp3074.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.OnBackPressedCallback

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Ensure ActionBar is enabled and set up with back button
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true) // Enable back button
            setDisplayShowHomeEnabled(true) // Ensure home/up button is shown
        }

        // Set up OnBackPressedCallback for modern back handling
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish() // Return to MainActivity without creating a new instance
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Use dispatcher for ActionBar back
        return true
    }
}