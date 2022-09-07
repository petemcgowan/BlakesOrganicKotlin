package com.buachaillmaith.blakesorganic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.buachaillmaith.blakesorganic.R
import com.buachaillmaith.blakesorganic.adapters.NewsAdapter
import com.buachaillmaith.blakesorganic.models.Article
import com.buachaillmaith.blakesorganic.models.Source
import com.buachaillmaith.blakesorganic.ui.NewsActivity
import com.buachaillmaith.blakesorganic.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : Fragment(R.layout.fragment_products) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_productsFragment_to_articleFragment,
                bundle
            )
        }
    }

    private fun setupRecyclerView() {

        var newsList = mutableListOf(   //rename throughout to newsList
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "Blakes Culture Blend Organic Whole Bean Coffee Catering Pack 1Kg",
                "Blakes Culture Blend Organic Whole Bean Coffee Catering Pack 1Kg",
                "2022-09-05T04:16:00Z",
                Source(1, "CBS Sports"),
                "Blakes Culture Blend Organic Whole Bean Coffee Catering Pack 1Kg",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
            Article(null,
                R.drawable.__coffee_packs_side_by_side,
                "Elizabeth Howell",
                "Blakes Culture Blend: Organic Whole Bean Coffee 250g",
                "Blakes Culture Blend: Organic Whole Bean Coffee 250g",
                "2022-09-05T04:11:34Z",
                Source(2, "Space.com"),
                "Blakes Culture Blend: Organic Whole Bean Coffee 250g",
                "https://www.space.com/spacex-starlink-group-4-20-space-tug-launch",
                "https://cdn.mos.cms.futurecdn.net/9sn8ayp4QWpzHpW6zyU8qR-1200-80.jpeg"
            ),
            Article(null,
                R.drawable.back_of_coffee_high_res_blakes_organic,
                "Amir Vera, Amanda Musa",
                "Purely Arabica Blend Organic Whole Bean Coffee Catering Pack 1Kg",
                "Purely Arabica Blend Organic Whole Bean Coffee Catering Pack 1Kg",
                "2022-09-05T03:39:00Z",
                Source(3, "CNN"),
                "Purely Arabica Blend Organic Whole Bean Coffee Catering Pack 1Kg",
                "https://www.cnn.com/2022/09/04/us/mutiny-bay-washington-plane-crash/index.html",
                "https://media.cnn.com/api/v1/images/stellar/prod/220905003331-01-mutiny-bay-washington-plane-crash.jpg?q=w_800,c_fill"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "Purely Arabica: Organic Whole Bean Coffee 250g",
                "Purely Arabica: Organic Whole Bean Coffee 250g",
                "2022-09-05T03:00:00Z",
                Source(4, "Hollywood Reporter"),
                "Purely Arabica: Organic Whole Bean Coffee 250g",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "750 ml Blakes Organic Milk Kefir -Natural",
                "750 ml Blakes Organic Milk Kefir -Natural",
                "2022-09-05T03:00:00Z",
                Source(5, "Pete Burquette Reporter"),
                "750 ml Blakes Organic Milk Kefir -Natural",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "250 ml Blakes Organic Milk Kefir -Natural flavour- Six bottle pack ",
                "250 ml Blakes Organic Milk Kefir -Natural flavour- Six bottle pack",
                "2022-09-05T03:00:00Z",
                Source(6, "Pete Burquette Reporter"),
                "250 ml Blakes Organic Milk Kefir -Natural flavour- Six bottle pack",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "250 ml Blakes Organic Milk Kefir -Natural",
                "250 ml Blakes Organic Milk Kefir -Natural",
                "2022-09-05T03:00:00Z",
                Source(6, "Pete Burquette Reporter"),
                "250 ml Blakes Organic Milk Kefir -Natural",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            )

        )

        newsAdapter = NewsAdapter(newsList)
        rvProducts.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}