package com.lambdaschool.congressdata

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Html
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_details_view.*


class DetailsActivity : AppCompatActivity() {



    private var profileImage: ImageView? = null
    private var profileName: TextView? = null
    private var profileParty: TextView? = null
    private var profileDistrict: TextView? = null
    private var profileTwitter: TextView? = null
    private var profileFacebook: TextView? = null
    private var profileMap: TextView? = null
    private var profilePhone: TextView? = null
    private var profileVotingBar: ProgressBar? = null
    private var profileCommitteeList: LinearLayout? = null
    private var profileSubcommitteeList: LinearLayout? = null


   private lateinit var memberId: String

    private lateinit var viewModel: CongresspersonProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        themeUtils.onActivityCreateSetTheme(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details_view)


        val intent = intent
        memberId = intent.getStringExtra("id")

        viewModel = ViewModelProviders.of(this).get(CongresspersonProfileViewModel::class.java)

        profileImage = profile_image
        profileName = profile_name
        profileParty = profile_party
        profileDistrict = profile_district
        profileTwitter = profile_twitter
        profileFacebook = profile_facebook
        profileMap = profile_map
        profilePhone = profile_phone
        profileVotingBar = profile_voting_bar
        profileCommitteeList = profile_committee_list
        profileSubcommitteeList = profile_subcommittee_list


        (findViewById<View>(R.id.profile_name) as TextView).setOnClickListener { themeUtils.nextTheme(this) }
    }

    override fun onStart() {
        super.onStart()

        //Changed
        viewModel.id = memberId

        viewModel.profile?.observe(this, Observer<CongresspersonProfile> { profile ->

            assert(profile != null)
            profileImage!!.setImageBitmap(profile!!.image)
            profileName!!.setText(profile.displayName)
            profileParty!!.setText(profile.party)
            profileDistrict!!.setText(profile.location)
            profileTwitter!!.text = Html.fromHtml("<a href=\"https://twitter.com/" + profile.twitterAccount + "\">Twitter</a>")
            profileFacebook!!.text = Html.fromHtml("<a href=\"https://www.facebook.com/" + profile.facebookAccount + "/\">Facebook</a>")
            profileMap!!.text = Html.fromHtml("<a href=\"https://www.google.com/maps/search/" + profile.office.replace(" ", "-") + "\">Office</a>")
            profilePhone!!.setText(profile.phone)


            profileVotingBar!!.progress = profile.primaryProgress.toInt()
            profileVotingBar!!.secondaryProgress = profile.secondaryProgress.toInt()

            for (name in profile.committees!!) {
                profileCommitteeList!!.addView(getDefaultTextView(name))
            }

            for (name in profile.subcommittees!!) {
                profileSubcommitteeList!!.addView(getDefaultTextView(name))
            }

            profileTwitter!!.setOnClickListener {
                if (profile.twitterAccount != "null") {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + profile.twitterAccount)))
                }
            }
            profileFacebook!!.setOnClickListener {
                if (profile.facebookAccount != "null") {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + profile.facebookAccount)))
                }
            }
            profileMap!!.setOnClickListener {
                if (profile.office != "null") {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/" + profile.office)))

                }
            }

        })


    }

    private fun getDefaultTextView(text: String): TextView {
        val dataView = TextView(this)
        dataView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        dataView.setPadding(5, 5, 5, 5)
        dataView.text = text
        return dataView
    }
}
