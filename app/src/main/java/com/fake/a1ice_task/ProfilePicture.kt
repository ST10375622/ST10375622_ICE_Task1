package com.fake.a1ice_task

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfilePicture : AppCompatActivity() {

    private lateinit var profilePic: ImageView
    private lateinit var uploadPhoto: Button
    private lateinit var HomePage : Button

    // Declare the image picker launcher properly
    private val imagePickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data

            // If an image is picked from gallery
            data?.data?.let { uri ->
                profilePic.setImageURI(uri)
                return@registerForActivityResult
            }

            // If a photo is taken from the camera
            val bitmap = data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                profilePic.setImageBitmap(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_picture)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profilePic = findViewById(R.id.profilepic)
        uploadPhoto = findViewById(R.id.btnphotoUpload)
        HomePage = findViewById(R.id.HomePage)


        // Set button click listener
        uploadPhoto.setOnClickListener {
            showImagePicker()
        }

        HomePage.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }

    private fun showImagePicker() {
        val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        val chooserIntent = Intent.createChooser(pickIntent, "Select Image")
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(takePhotoIntent))

        imagePickerLauncher.launch(chooserIntent)
    }
}
