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
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment(R.layout.fragment_history) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "HistoryFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_historyFragment_to_articleFragment,
                bundle
            )
        }

//        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
//            when(response) {
//                is Resource.Success -> {
//                    hideProgressBar()
//                    response.data?.let { newsResponse ->
//                        newsAdapter.differ.submitList(newsResponse.articles)
//                    }
//                }
//                is Resource.Error -> {
//                    hideProgressBar()
//                    response.message?.let { message ->
//                        Log.e(TAG, "An error occurred: $message")
//                    }
//                }
//                is Resource.Loading -> {
//                    showProgressBar()
//                }
//            }
//        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {

        var newsList = mutableListOf(   //rename throughout to newsList
            Article(null,
                R.drawable._50ml_kefir_550x825,
                "Barrett Sallee",
                "The company is focused only on certified Organic produce.",
                "The company is focused only on certified Organic produce.",
                "2022-09-05T04:16:00Z",
                Source(1, "CBS Sports"),
                "Blake’s Always Organic is based in The Food Hub, Drumshanbo, Co. Leitrim since 2012",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
            Article(null,
                R.drawable.__coffee_packs_side_by_side,
                "Elizabeth Howell",
                "Sean McGloin became aware of the health benefits of the fermented milk kefir and was making kefir for his family before developing the product on a small commercial scale.",
                "Sean McGloin became aware of the health benefits of the fermented milk kefir and was making kefir for his family before developing the product on a small commercial scale.",
                "2022-09-05T04:11:34Z",
                Source(2, "Space.com"),
                "\"Our current products are Organic Kefir, (a probiotic health drink for gut revitalisation made with whole organic milk.) and Whole-bean Artisan Organic coffees.",
                "https://www.space.com/spacex-starlink-group-4-20-space-tug-launch",
                "https://cdn.mos.cms.futurecdn.net/9sn8ayp4QWpzHpW6zyU8qR-1200-80.jpeg"
            ),
            Article(null,
                R.drawable.back_of_coffee_high_res_blakes_organic,
                "Amir Vera, Amanda Musa",
                "Hundreds of years ago kefir was found high in the Caucasus mountains villages of nomadic shepherds who had abnormally good health.",
                "Hundreds of years ago kefir was found high in the Caucasus mountains villages of nomadic shepherds who had abnormally good health.",
                "2022-09-05T03:39:00Z",
                Source(3, "CNN"),
                "Kefir originates in the Caucasus mountains. ",
                "https://www.cnn.com/2022/09/04/us/mutiny-bay-washington-plane-crash/index.html",
                "https://media.cnn.com/api/v1/images/stellar/prod/220905003331-01-mutiny-bay-washington-plane-crash.jpg?q=w_800,c_fill"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "On further research, they discovered that part of the diet was a milk product that was stored in bags or containers made from calf stomachs.",
                "On further research, they discovered that part of the diet was a milk product that was stored in bags or containers made from calf stomachs.",
                "2022-09-05T03:00:00Z",
                Source(4, "Hollywood Reporter"),
                "While half the world was dying of malnutrition and disease, these shepherds and their families lived long healthy lives with little or no disease.",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "In 2016, Blakes Always Organic commenced selling “Feel Good” Organic Kefir.",
                "In 2016, Blakes Always Organic commenced selling “Feel Good” Organic Kefir.",
                "2022-09-05T03:00:00Z",
                Source(5, "Pete Burquette Reporter"),
                "As temperatures rose the natural bacteria in the wall of the calf’s stomach bag impregnated the milk causing fermentation resulting in billions of good bacteria that was regular drank by the shepherds to achieve good health.",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "We had to move to a 200 litre vat within 3 months and in 2018 we had to purchase a 850 litre vat.",
                "We had to move to a 200 litre vat within 3 months and in 2018 we had to purchase a 850 litre vat.",
                "2022-09-05T03:00:00Z",
                Source(6, "Pete Burquette Reporter"),
                "Starting off, we made batches of kefir in a small 20 litre Bain Marie, which we bottled and labelled by hand. ",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "Three years later, and our production scale has grown continuously to cater for the increasing demand as the undisputed health benefits of milk kefir is the main driver of sales.",
                "Three years later, and our production scale has grown continuously to cater for the increasing demand as the undisputed health benefits of milk kefir is the main driver of sales.",
                "2022-09-05T03:00:00Z",
                Source(6, "Pete Burquette Reporter"),
                "We currently produce around 1600 litres per week. The product proved to be very popular with our health conscious customers.",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            )

        )

        newsAdapter = NewsAdapter(newsList)
        rvHistory.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}