package pham.user.colourmemoryandroid.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.pm.ActivityInfo
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pham.user.colourmemoryandroid.R
import pham.user.colourmemoryandroid.databinding.FragmentMainBinding
import pham.user.colourmemoryandroid.di.Injectable
import pham.user.colourmemoryandroid.util.Constants.CardState
import pham.user.colourmemoryandroid.vo.Card
import pham.user.themovie.util.ext.getColorFromResId
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: MainViewModel
    private lateinit var viewDataBinding: FragmentMainBinding

    lateinit var cardAdapter: CardAdapter
    val contentList = ArrayList<Int>()
    val cardList = ArrayList<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_main, container, false)!!
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        setupBackgroundAndActionBar()

        cardAdapter = CardAdapter(object : CardAdapter.CardOnClickCallback {
            override fun onClick(card: Card) {
                card.state = CardState.OPEN.value
            }

        })

        viewDataBinding.gridView.apply {
            adapter = cardAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 4)
        }

        for(i in 0..1) {
            contentList.add(R.drawable.colour1)
            contentList.add(R.drawable.colour2)
            contentList.add(R.drawable.colour3)
            contentList.add(R.drawable.colour4)
            contentList.add(R.drawable.colour5)
            contentList.add(R.drawable.colour6)
            contentList.add(R.drawable.colour7)
            contentList.add(R.drawable.colour8)
        }
        contentList.shuffle()

        contentList.forEach {
            cardList.add(Card(it, CardState.CLOSE.value))
        }
        cardAdapter.replace2(cardList)
        cardAdapter.notifyDataSetChanged()
    }

    private fun setupBackgroundAndActionBar() {
        val window = activity.window
        window.decorView.setBackgroundColor(activity.getColorFromResId(R.color.colorPrimary))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = activity.getColorFromResId(R.color.colorPrimary)
        }

        //(activity as AppCompatActivity).setSupportActionBar(viewDataBinding.toolbar)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        if (actionBar != null) {
//            (activity.findViewById<View>(R.id.text_view_action_bar) as TextView)?.setText(R.string.title_cards)
//            (activity.findViewById<View>(R.id.tvMenuLeft) as TextView)?.setText(R.string.group)
//            (activity.findViewById<View>(R.id.tvMenuLeft) as TextView)?.setOnClickListener({
//                val intent = Intent(activity, GroupActivity::class.java)
//                startActivity(intent)
//            })
        }
    }
}