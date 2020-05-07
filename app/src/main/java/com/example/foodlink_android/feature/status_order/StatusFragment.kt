package com.example.foodlink_android.feature.status_order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R
import com.example.foodlink_android.common.adapters.StatusOrderAdapter
import org.jetbrains.anko.support.v4.toast

class StatusFragment : Fragment() {

    private lateinit var listRecycler: RecyclerView
    private lateinit var adapterOrder: StatusOrderAdapter

    companion object {
        fun newInstance(data: Bundle? = null): StatusFragment {
            val fragment = StatusFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.status_order_fragment, container, false)
    }

    private fun bindViews(view: View) = with(view) {
        listRecycler = findViewById(R.id.list_status_orders)
        adapterOrder = StatusOrderAdapter(generateTestData())
        adapterOrder.setClickInfo(object : StatusOrderAdapter.ClickListenerInfo{
            override fun infoClick() {
                toast("Вытащим диалог!")
            }

        })
        listRecycler.apply {
            adapter = adapterOrder
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

    private fun generateTestData(): ArrayList<StatusOrder> {
        return arrayListOf(
            StatusOrder(
                7600,
                descriptionOrder = "Двойной бургер с фри кола...",
                imageBig = null,
                time = "15:24",
                imageChef = null,
                status = 2
            ),
            StatusOrder(
                6800,
                descriptionOrder = "Пицца и немного бургера с колой",
                imageBig = null,
                time = "12:30",
                imageChef = null,
                status = 3
            ),
            StatusOrder(
                5400,
                descriptionOrder = "Что-то что можно скушать и не голодать",
                imageBig = null,
                time = "15:24",
                imageChef = null,
                status = 4
            ),
            StatusOrder(
                720,
                descriptionOrder = "Двойной бургер с фри кола...",
                imageBig = null,
                time = "10:11",
                imageChef = null,
                status = 3
            ),
            StatusOrder(
                7600,
                descriptionOrder = "Двойной бургер с фри кола...",
                imageBig = null,
                time = "15:24",
                imageChef = null,
                status = 3
            )

        )
    }
}