package top.fumiama.copymanga.ui.cardflow.search

import android.os.Bundle
import android.util.Log
import top.fumiama.copymanga.view.template.InfoCardLoader
import top.fumiama.copymanga.api.Config
import top.fumiama.dmzj.copymanga.R
import java.net.URLEncoder
import java.nio.charset.Charset

@ExperimentalStdlibApi
class SearchFragment : InfoCardLoader(R.layout.fragment_search, R.id.action_nav_search_to_nav_book) {
    private var query: String? = null
    private var type: String? = null
    override fun getApiUrl() =
        getString(R.string.searchApiUrl).format(page * 21, query, type, Config.platform.value)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isFirstInflate) {
            query = arguments?.getCharSequence("query")?.toString()?.let { q -> URLEncoder.encode(q, Charset.defaultCharset().name()) }
            type = arguments?.getString("type")
            Log.d("MySF", "get query=$query, type=$type")
        }
    }
}
