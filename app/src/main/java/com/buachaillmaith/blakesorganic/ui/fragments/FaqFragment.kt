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
import kotlinx.android.synthetic.main.fragment_faq.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FaqFragment : Fragment(R.layout.fragment_faq) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG = "FaqFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_faqFragment_to_articleFragment,
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

        var savedList = mutableListOf(
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "Generally, we have found that the recommended daily amount is around 100 grams per day, so half of one of our 250g bottles of Blakes ‘Feel Good’ Kefir should be fine, but you might find it beneficial to start on a third of the bottle to allow your gut to acclimatize to the kefir for the first few days.",
                "Generally, we have found that the recommended daily amount is around 100 grams per day, so half of one of our 250g bottles of Blakes ‘Feel Good’ Kefir should be fine, but you might find it beneficial to start on a third of the bottle to allow your gut to acclimatize to the kefir for the first few days.",
                "2022-09-05T04:16:00Z",
                Source(1, "CBS Sports"),
                "How much Kefir should I take?",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "Yes. The Kefir bottles are made from P.E.T. plastic and fully recyclable, as is the lid. Our coffee pouches are also recyclable, and we hope to introduce compostable/biodegradable coffee pouches in the near future.",
                "Yes. The Kefir bottles are made from P.E.T. plastic and fully recyclable, as is the lid. Our coffee pouches are also recyclable, and we hope to introduce compostable/biodegradable coffee pouches in the near future.",
                "2022-09-05T04:16:00Z",
                Source(2, "CBS Sports"),
                "Are your wrappers/labels and bottles recyclable?",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "The kefir can be consumed straight from the bottle. Some people may find the taste a bit sharp for their pallet, and if that is the case, you can make a smoothie or add a little fruit juice to sweeten up the kefir. We would recommend that you do this shortly before consumption, however, as the kefir may begin to ferment again from the natural sugars in the fruit. (This is referred to as Double Fermentation and is perfectly natural, but it may affect the flavour and consistency, if left out of a chilled environment for even a short period of time).\n" +
                        "        Alternatively, why not soak some porridge oats overnight in kefir for a healthy creamy breakfast?",
                "The kefir can be consumed straight from the bottle. Some people may find the taste a bit sharp for their pallet, and if that is the case, you can make a smoothie or add a little fruit juice to sweeten up the kefir. We would recommend that you do this shortly before consumption, however, as the kefir may begin to ferment again from the natural sugars in the fruit. (This is referred to as Double Fermentation and is perfectly natural, but it may affect the flavour and consistency, if left out of a chilled environment for even a short period of time).\n" +
                        "        Alternatively, why not soak some porridge oats overnight in kefir for a healthy creamy breakfast?",
                "2022-09-05T04:16:00Z",
                Source(3, "CBS Sports"),
                "How do you drink your Kefir?",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
        Article(null,
            R.drawable._50ml_kefir_550x825,
        "Barrett Sallee",
        "Our Kefir is a live product, and will continue to ferment, especially if the temperature of the product goes over 5 degrees Centigrade. It can, therefore, be prone to separation into ‘curds’ and ‘whey’. The pH level will also be slightly sharper if this happens.\n" +
                "\n" +
                "We aim for a rich creamy texture and a low pH for a consistent product, but some people prefer a sharper taste. If that is the case, then simple leave the kefir at room temperature for a few hours and it will become more acidic tasting.\n" +
                "\n" +
                "If you find that it has separated slightly, simply shake the bottle before consumption.\n" +
                "\n" +
                "*Alternatively , you can allow the kefir to seperate fully into curds and whey, and drain off the watery whey into a cloth covered sieve using some muslin (or a clean tea towel will do). The curds you have left will make a delicious cream cheese (try adding some wild garlic, green onions, or chives to make it even tastier.)",
        "Our Kefir is a live product, and will continue to ferment, especially if the temperature of the product goes over 5 degrees Centigrade. It can, therefore, be prone to separation into ‘curds’ and ‘whey’. The pH level will also be slightly sharper if this happens.\n" +
                "\n" +
                "We aim for a rich creamy texture and a low pH for a consistent product, but some people prefer a sharper taste. If that is the case, then simple leave the kefir at room temperature for a few hours and it will become more acidic tasting.\n" +
                "\n" +
                "If you find that it has separated slightly, simply shake the bottle before consumption.\n" +
                "\n" +
                "*Alternatively , you can allow the kefir to seperate fully into curds and whey, and drain off the watery whey into a cloth covered sieve using some muslin (or a clean tea towel will do). The curds you have left will make a delicious cream cheese (try adding some wild garlic, green onions, or chives to make it even tastier.)",
        "2022-09-05T04:16:00Z",
        Source(4, "CBS Sports"),
        "I bought some kefir recently, but i found that it had a watery liquid on top of the bottle when i took it out of the fridge the next day. Is that normal?",
        "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
        "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
        )

        )

        newsAdapter = NewsAdapter(savedList)
        rvFaq.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}