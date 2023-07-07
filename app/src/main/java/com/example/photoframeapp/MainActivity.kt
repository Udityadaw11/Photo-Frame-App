package com.example.photoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //create a variable that define which image is show
    var currentImage = 0

    //variable for image
    lateinit var imageView: ImageView

    //FOR NAMES create an array
    var names = arrayOf("MS Dhoni", "Virat Kohli", "Narendra Modi", "ShahRukh Khan")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.imgPrevious)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val textShow = findViewById<TextView>(R.id.textView)
        //the parameter passed in findViewById is of the type Integer

        prev.setOnClickListener {

            val idCurrentImage = "pic$currentImage" // it is of type String

            //String idCurrentImage is converted into integer address associated with it.

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImage, "id",packageName)

            //getIdentifier have 3 parameters, name (Name of desired resource), defType (Default Resource Type, it optional) and defPackage (Default package, it is also optional. It can be null for an explict package)

            //initialising imageview button
            imageView = findViewById(idCurrentImageInt)

            //to make current image invisible
            imageView.alpha = 0f //(it accept float value)

            //to get the previous image
            currentImage = (4 + currentImage -1)%4

            // to get the current image
            val imageShow = "pic$currentImage"
            //convert this to integer
            val imageShowInt =this.resources.getIdentifier(imageShow,"id", packageName)

            // shw the image
            imageView = findViewById(imageShowInt)
            imageView.alpha = 1f //Image will become visible

            // for name
            textShow.text = names[currentImage]

        }

        //for next click
        next.setOnClickListener {
            //get id
            val currentImageId ="pic$currentImage"
            //convert it to integer
            val currentImageInt = this.resources.getIdentifier(currentImageId,"id", packageName)

            //initialise imageView
            imageView = findViewById(currentImageInt)
            imageView.alpha = 0f

            //to get the id of next image
            currentImage = (currentImage + 1)%4

            //next image id
            val imageShow = "pic$currentImage"
            val imageShowInt = this.resources.getIdentifier(imageShow, "id",packageName)

            //initialise the image view
            imageView = findViewById(imageShowInt)
            imageView.alpha = 1f

            // for names
            textShow.text = names[currentImage]
        }
    }
}