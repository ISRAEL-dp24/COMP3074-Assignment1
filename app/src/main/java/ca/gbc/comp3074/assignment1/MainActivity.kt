package ca.gbc.comp3074.assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get references to input fields and output text views
        val hoursInput = findViewById<EditText>(R.id.hoursInput)
        val rateInput = findViewById<EditText>(R.id.rateInput)
        val taxInput = findViewById<EditText>(R.id.taxInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val aboutButton = findViewById<Button>(R.id.aboutButton)
        val payText = findViewById<TextView>(R.id.payText)
        val overtimePayText = findViewById<TextView>(R.id.overtimePayText)
        val totalPayText = findViewById<TextView>(R.id.totalPayText)
        val taxText = findViewById<TextView>(R.id.taxText)

        // Set click listener for Calculate button
        calculateButton.setOnClickListener {
            // Get input values and convert to Double
            val hours = hoursInput.text.toString().toDoubleOrNull() ?: 0.0
            val rate = rateInput.text.toString().toDoubleOrNull() ?: 0.0
            val taxRate = taxInput.text.toString().toDoubleOrNull() ?: 0.0

            // Calculate pay
            val pay: Double
            val overtimePay: Double
            if (hours <= 40) {
                pay = hours * rate
                overtimePay = 0.0
            } else {
                pay = 40 * rate
                overtimePay = (hours - 40) * rate * 1.5
            }
            val totalPay = pay + overtimePay
            val tax = pay * taxRate

            // Display results
            payText.text = "Pay: %.2f".format(pay)
            overtimePayText.text = "Overtime Pay: %.2f".format(overtimePay)
            totalPayText.text = "Total Pay: %.2f".format(totalPay)
            taxText.text = "Tax: %.2f".format(tax)
        }

        // Set click listener for About button
        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}