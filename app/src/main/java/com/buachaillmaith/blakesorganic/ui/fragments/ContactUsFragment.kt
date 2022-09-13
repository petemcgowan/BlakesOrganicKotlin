package com.buachaillmaith.blakesorganic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.buachaillmaith.blakesorganic.R
import com.buachaillmaith.blakesorganic.adapters.NewsAdapter
import com.buachaillmaith.blakesorganic.models.Article
import com.buachaillmaith.blakesorganic.models.Source
import com.buachaillmaith.blakesorganic.ui.NewsActivity
import com.buachaillmaith.blakesorganic.ui.NewsViewModel
import com.buachaillmaith.blakesorganic.util.Constants.Companion.SEARCH_NEWS_TIME_DELAY
import kotlinx.android.synthetic.main.fragment_contact_us.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContactUsFragment : Fragment(R.layout.fragment_contact_us) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG = "ContactUsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_contactUsFragment_to_articleFragment,
                bundle
            )
        }

        var job: Job? = null
//        etSearch.addTextChangedListener { editable ->
//            job?.cancel()
//            job = MainScope().launch {
//                delay(SEARCH_NEWS_TIME_DELAY)
//                editable?.let {
//                    if(editable.toString().isNotEmpty()) {
//                        viewModel.searchNews(editable.toString())
//                    }
//                }
//            }
//        }
    }


    private fun setupRecyclerView() {

        //val list : List<Article> = listOf()

        var contactUsList = mutableListOf(
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "Unit 3, The Food Hub\n" +
                        "Carricknabrack",
                "Unit 3, The Food Hub\n" +
                        "Carricknabrack",
                "2022-09-05T04:16:00Z",
                Source(1, "CBS Sports"),
                "Blakes Always Organic Ltd.",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "Drumshanbo\n" +
                        "Co. Leitrim\n" +
                        "N41 HY67\n" +
                        "Ireland",
                "Drumshanbo\n" +
                        "Co. Leitrim\n" +
                        "N41 HY67\n" +
                        "Ireland",
                "2022-09-05T04:16:00Z",
                Source(2, "CBS Sports"),
                "Phone : (+353) 0719640537",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            )
        )

        newsAdapter = NewsAdapter(contactUsList)
        rvContactUs.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}