package com.buachaillmaith.blakesorganic.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.buachaillmaith.blakesorganic.R
import com.buachaillmaith.blakesorganic.adapters.NewsAdapter
import com.buachaillmaith.blakesorganic.models.Article
import com.buachaillmaith.blakesorganic.models.Source
import com.buachaillmaith.blakesorganic.ui.NewsActivity
import com.buachaillmaith.blakesorganic.ui.NewsViewModel
import com.buachaillmaith.blakesorganic.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "BreakingNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_breakingNewsFragment_to_articleFragment,
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
                "Despite a roaring comeback taking advantage of multiple Florida State miscues, it was LSU that made the final mistake on Sunday night in a 24-23 victory by the Seminoles at the Mercedes-Benz Superdom…",
                "LSU appeared set for an epic comeback only for special teams to cost it with no time remaining",
                "2022-09-05T04:16:00Z",
                Source(1, "CBS Sports"),
                "LSU vs. Florida State score, takeaways: Walk-off blocked extra point saves 'Noles from Tigers' late surge - CBS Sports",
                "https://www.cbssports.com/college-football/news/lsu-vs-florida-state-score-takeaways-walk-off-blocked-extra-point-saves-noles-from-tigers-late-surge/live/",
                "https://sportshub.cbsistatic.com/i/r/2022/09/05/393fca4a-e4f1-4e35-be65-7175459eb852/thumbnail/1200x675/93391b41c76e0d387cd1f7abd230c427/noles.jpg"
            ),
            Article(null,
                R.drawable.__coffee_packs_side_by_side,
                "Elizabeth Howell",
                "SpaceX sent a space tug aloft along with another big batch of its Starlink internet satellites on Sunday night (Sept. 4) — and landed a rocket on a ship at sea as well.  A SpaceX  Falcon 9 rocket li… ",
                "It was SpaceX's 40th launch of 2022.",
                "2022-09-05T04:11:34Z",
                Source(2, "Space.com"),
                "SpaceX launches 51 Starlink satellites and a space tug to orbit - Space.com",
                "https://www.space.com/spacex-starlink-group-4-20-space-tug-launch",
                "https://cdn.mos.cms.futurecdn.net/9sn8ayp4QWpzHpW6zyU8qR-1200-80.jpeg"
            ),
            Article(null,
                R.drawable.back_of_coffee_high_res_blakes_organic,
                "Amir Vera, Amanda Musa",
                "Rescuers are searching for nine people who are unaccounted for after a float plane crashed in Washingtons Mutiny Bay Sunday afternoon, officials said. Ten people, including a child, were on board t",
                "Rescuers are searching for nine people who are unaccounted for after a float plane crashed in Washington's Mutiny Bay Sunday afternoon, officials said.",
                "2022-09-05T03:39:00Z",
                Source(3, "CNN"),
                "Float plane carrying 10 people, including a child, crashes into Washington's Mutiny Bay, Coast Guard says - CNN",
                "https://www.cnn.com/2022/09/04/us/mutiny-bay-washington-plane-crash/index.html",
                "https://media.cnn.com/api/v1/images/stellar/prod/220905003331-01-mutiny-bay-washington-plane-crash.jpg?q=w_800,c_fill"
            ),
            Article(null,
                R.drawable.blakes_culture_blend_organic_whole_bean_coffee_catering_pack_1kg,
                "Tyler Coates",
                "Lee Yoo-mi has won the 2022 Emmy for outstanding guest actress in a drama series for her role in Netflix’s Squid Game, becoming the first Korean actress to take home the prize in this category. Colman… ",
                "Lee Yoo-mi has won the 2022 Emmy for outstanding guest actress in a drama series for her role in Netflix’s Squid Game, becoming the first Korean actress to take home the prize in this category. Colman Domingo has won outstanding guest actor in a drama series …",
                "2022-09-05T03:00:00Z",
                Source(4, "Hollywood Reporter"),
                "Creative Arts Emmys: Lee Yoo-mi and Colman Domingo Win for Guest Acting in a Drama Series - Hollywood Reporter",
                "https://www.hollywoodreporter.com/tv/tv-news/emmys-2022-guest-acting-drama-series-1235212194/",
                "https://www.hollywoodreporter.com/wp-content/uploads/2022/09/Emmys-2022-Squid-Game-Euphoria-Split-Publicity-H-2022.jpg?w=1024"
            )
        )

        newsAdapter = NewsAdapter(newsList)
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}