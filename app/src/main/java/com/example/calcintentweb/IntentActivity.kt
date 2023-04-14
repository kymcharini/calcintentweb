package com.example.calcintentweb

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.net.URI

class IntentActivity : AppCompatActivity() {
    lateinit var buttonsms:Button
    lateinit var buttoncall:Button
    lateinit var buttondial:Button
    lateinit var buttoncamera:Button
    lateinit var buttonmpesa:Button
    lateinit var buttonshare:Button
    lateinit var buttonemail:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        buttonsms=findViewById(R.id.Btn_SMS)
        buttoncall=findViewById(R.id.Btn_Call)
        buttondial=findViewById(R.id.Btn_Dial)
        buttoncamera=findViewById(R.id.Btn_Camera)
        buttonmpesa=findViewById(R.id.Btn_Mpesa)
        buttonshare=findViewById(R.id.Btn_Share)
        buttonemail=findViewById(R.id.Btn_Email)

        buttonsms.setOnClickListener {
             val uri=Uri.parse("smsto:0718261597")
            val intent=Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("Hello","Good morning")
            startActivity(intent)
        }
        buttoncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254718261597"))
            if (ContextCompat.checkSelfPermission(this@IntentActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            { ActivityCompat.requestPermissions(this@IntentActivity, arrayOf(Manifest.permission.CALL_PHONE), 1)
            } else {
                startActivity(intent) }
        }
        buttondial.setOnClickListener {
            val nambari="+254718261597"
            val intent=Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",nambari,null))
            startActivity(intent)
        }
        buttoncamera.setOnClickListener {
            val takepic=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepic,1)
        }
        buttonmpesa.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        buttonshare.setOnClickListener {
            val shareIntent=Intent(Intent.ACTION_SEND)
            shareIntent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Hi click to download")
            startActivity(shareIntent)
        }
        buttonemail.setOnClickListener {
            val intent=Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","kymcharini@gmail.com",null))
        }
    }
}