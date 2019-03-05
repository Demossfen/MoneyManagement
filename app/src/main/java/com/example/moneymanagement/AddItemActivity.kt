package com.example.moneymanagement

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_item.*

class AddItemActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        //make button + active when both fields not empty
        val textWatcher =object :TextWatcher {
            override fun afterTextChanged(s: Editable) {
                add_btn.isEnabled = name.text.isNotEmpty() && price.text.isNotEmpty()
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        }
        price.addTextChangedListener(textWatcher)
        name.addTextChangedListener(textWatcher)

        //make button + clickable
        add_btn.setOnClickListener {
           val toast =  Toast.makeText(this, "name ${name.text}  price ${price.text}", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()

            // onClick(add_btn)
        }

    }




    /*  if ( !s.toString().equals("",ignoreCase = true))
                   if (price.text.hashCode() == s.hashCode()) {
                       val value = s.toString()+  "₴"
                       price.removeTextChangedListener(this)
                       price.setText(value)
                   } else if (name.text.hashCode() == s.hashCode()) {
                       val value = s.toString()
                       name.removeTextChangedListener(this)
                       Log.i("AddItemActivity", "value " + value)
                       name.setText(value)
                       name.addTextChangedListener(this)
                   }*/

    /* private fun onClick(v:View?){
         when(v?.id){
             R.id.add_btn ->{
                 Toast.makeText(this,"name ${name.text}  price ${price.text}",Toast.LENGTH_SHORT).show()
             }
         else ->{}
         }
     }*/


}


