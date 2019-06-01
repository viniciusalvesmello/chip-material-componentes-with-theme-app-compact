package viniciusalvesmello.github.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val chipContext = applicationContext
        chipContext.setTheme(R.style.AppThemeMaterialComponents)
        
        for (chipId: Int in 1..10) {
            cgListChips.addView(
                createChip(
                    context = chipContext,
                    id = chipId,
                    text = "Chip $chipId"
                )
            )
        }

    }
    
    fun createChip(context: Context, id: Int, text: String): Chip {
        val chip = Chip(context, null, R.style.Widget_MaterialComponents_Chip_Filter)
        chip.id = id
        chip.text = text
        chip.isClickable = true
        chip.isCheckable = true
        chip.setOnClickListener {
            showClick(context, it as Chip)
        }
        return chip
    }
    
    fun showClick(context: Context, chip: Chip) {
        ("Click chip " + chip.id + ": " + chip.text).toastLong(context)
    }
    
    fun String.toastLong(context: Context) {
        Toast.makeText(
            context,
            this,
            Toast.LENGTH_LONG
        ).show()
    }
}
