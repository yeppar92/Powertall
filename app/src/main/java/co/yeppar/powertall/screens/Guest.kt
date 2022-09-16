package co.yeppar.powertall.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.yeppar.powertall.R


class Guest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.navigationBarColor = resources.getColor(R.color.colorAccent)
        setContentView(R.layout.activity_guest)
    }
}