package top.fumiama.copymanga.ui.cardflow.history

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import top.fumiama.copymanga.MainActivity
import top.fumiama.copymanga.view.template.InfoCardLoader
import top.fumiama.copymanga.api.Config
import top.fumiama.dmzj.copymanga.R

@OptIn(ExperimentalStdlibApi::class)
class HistoryFragment : InfoCardLoader(R.layout.fragment_history, R.id.action_nav_history_to_nav_book, isHistoryBook = true) {
    override fun getApiUrl() =
        getString(R.string.historyApiUrl).format(page * 21, Config.platform.value)

    override fun onCreate(savedInstanceState: Bundle?) {
        if (MainActivity.member?.hasLogin != true) {
            Toast.makeText(context, R.string.noLogin, Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
        super.onCreate(savedInstanceState)
    }
}
