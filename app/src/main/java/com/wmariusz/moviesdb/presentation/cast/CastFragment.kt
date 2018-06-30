package com.wmariusz.moviesdb.presentation.cast

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.observeNotNull
import com.wmariusz.moviesdb.util.LineDividerItemDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_cast.castList
import javax.inject.Inject

class CastFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CastViewModel

    private val adapter by lazy { CastAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_cast, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        castList.adapter = adapter
        castList.layoutManager = LinearLayoutManager(context)
        castList.addItemDecoration(LineDividerItemDecoration(context!!, R.drawable.list_item_divider))

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CastViewModel::class.java)
        observeViewModel()

        val movieId = CastFragmentArgs.fromBundle(arguments).movieId
        viewModel.cast(movieId)
    }

    private fun observeViewModel() {
        viewModel.cast.observeNotNull(this) { cast ->
            adapter.swapData(cast)
        }
    }
}